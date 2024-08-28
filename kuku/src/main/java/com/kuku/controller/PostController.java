package com.kuku.controller;

import com.kuku.dto.PostDto;
import com.kuku.dto.mapper.PostDtoMapper;
import com.kuku.exception.PostException;
import com.kuku.exception.UserException;
import com.kuku.model.Posts;
import com.kuku.model.User;
import com.kuku.request.PostReplyReq;
import com.kuku.response.ApiResponse;
import com.kuku.service.PostService;
import com.kuku.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
public class PostController {

    @Autowired
    private final PostService postService;

    @Autowired
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<PostDto> createPost
            (@RequestBody Posts req, @RequestHeader("Authorization") String jwt) throws UserException, PostException {

        User user = userService.findUserProfileByJwt(jwt);
        Posts post = postService.createPost(req,user);
        PostDto postDto = PostDtoMapper.toPostDto(post,user);

        return new ResponseEntity<>(postDto, HttpStatus.CREATED);
    }

    @PostMapping("/reply")
    public ResponseEntity<PostDto> createReply
            (@RequestBody PostReplyReq req, @RequestHeader("Authorization") String jwt) throws UserException, PostException {

        User user = userService.findUserProfileByJwt(jwt);
        Posts post = postService.postReply(req,user);
        PostDto postDto = PostDtoMapper.toPostDto(post,user);

        return new ResponseEntity<>(postDto, HttpStatus.CREATED);
    }

    @PutMapping("/{postId}/repost")
    public ResponseEntity<PostDto> repost
            (@PathVariable Long postId, @RequestHeader("Authorization") String jwt) throws UserException, PostException {

        User user = userService.findUserProfileByJwt(jwt);
        Posts post = postService.repost(postId,user);
        PostDto postDto = PostDtoMapper.toPostDto(post,user);

        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById
            (@PathVariable Long postId, @RequestHeader("Authorization") String jwt) throws UserException, PostException {

        User user = userService.findUserProfileByJwt(jwt);
        Posts post = postService.findById(postId);
        PostDto postDto = PostDtoMapper.toPostDto(post,user);

        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<ApiResponse> deletePost
            (@PathVariable Long postId, @RequestHeader("Authorization") String jwt) throws UserException, PostException {

        User user = userService.findUserProfileByJwt(jwt);
        postService.deletePost(postId, user.getId());

        ApiResponse response = new ApiResponse("Post deleted successfully", true);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<PostDto>> getAllPosts
            (@RequestHeader("Authorization") String jwt) throws UserException, PostException {

        User user = userService.findUserProfileByJwt(jwt);
        List<Posts> post = postService.findAllPosts();
        List<PostDto> posts = PostDtoMapper.toPostDtos(post,user);

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PostDto>> getUsersPosts
            (@RequestHeader("Authorization") String jwt) throws UserException, PostException {

        User user = userService.findUserProfileByJwt(jwt);
        List<Posts> post = postService.getUserPosts(user);
        List<PostDto> posts = PostDtoMapper.toPostDtos(post,user);

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/likes")
    public ResponseEntity<List<PostDto>> getUsersLikedPosts
            (@RequestHeader("Authorization") String jwt) throws UserException, PostException {

        User user = userService.findUserProfileByJwt(jwt);
        List<Posts> post = postService.findByLikesContainsUser(user);
        List<PostDto> posts = PostDtoMapper.toPostDtos(post,user);

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}
