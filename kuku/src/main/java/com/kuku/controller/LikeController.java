package com.kuku.controller;

import com.kuku.dto.LikeDto;
import com.kuku.dto.mapper.LikeDtoMapper;
import com.kuku.exception.PostException;
import com.kuku.exception.UserException;
import com.kuku.model.Likes;
import com.kuku.model.User;
import com.kuku.service.LikeService;
import com.kuku.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class LikeController {

    @Autowired
    private final UserService userService;
    @Autowired
    private final LikeService likeService;

    @PostMapping("/{postId}")
    public ResponseEntity<LikeDto> likePost(@PathVariable Long postId, @RequestHeader("Authorization") String jwt) throws UserException, PostException {

        User user = userService.findUserProfileByJwt(jwt);
        Likes like = likeService.likePost(postId,user);

        return new ResponseEntity<>(LikeDtoMapper.toLikeDto(like,user), HttpStatus.CREATED);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<LikeDto>> getAllLikes(@PathVariable Long postId, @RequestHeader("Authorization") String jwt) throws UserException, PostException {

        User user = userService.findUserProfileByJwt(jwt);
        List<Likes> likes = likeService.getAllLikes(postId);

        return new ResponseEntity<>(LikeDtoMapper.toLikeDtos(likes,user), HttpStatus.OK);
    }
}
