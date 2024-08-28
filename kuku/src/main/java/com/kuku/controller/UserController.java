package com.kuku.controller;

import com.kuku.dto.UserDto;
import com.kuku.dto.mapper.UserDtoMapper;
import com.kuku.exception.UserException;
import com.kuku.model.User;
import com.kuku.service.UserService;
import com.kuku.util.UserUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getUserProfile(@RequestHeader("Authorization") String jwt) throws UserException{
        User user = userService.findUserProfileByJwt(jwt);
        UserDto userDto = UserDtoMapper.toUserDto(user);
        userDto.setReq_user(true);

        return new ResponseEntity<>(userDto, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId, @RequestHeader("Authorization") String jwt) throws UserException{
        User user = userService.findUserProfileByJwt(jwt);
        User user2 = userService.findUserById(userId);
        UserDto userDto = UserDtoMapper.toUserDto(user2);
        userDto.setReq_user(UserUtil.isReqUser(user,user2));
        userDto.setFollowed(UserUtil.isFollowedByReqUser(user,user2));

        return new ResponseEntity<>(userDto, HttpStatus.ACCEPTED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserDto>> searchUser(@RequestParam String query, @RequestHeader("Authorization") String jwt) throws UserException{
        User userByJwt = userService.findUserProfileByJwt(jwt);

        List<User> users = userService.searchUser(query);

        return new ResponseEntity<>(UserDtoMapper.toUserDtos(users), HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> searchUser(@RequestBody User user, @RequestHeader("Authorization") String jwt) throws UserException{
        User userByJwt = userService.findUserProfileByJwt(jwt);
        User updateUser = userService.updateUser(userByJwt.getId(), user);

        return new ResponseEntity<>(UserDtoMapper.toUserDto(updateUser), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{userId}/follow")
    public ResponseEntity<UserDto> followUser(@PathVariable Long userId, @RequestHeader("Authorization") String jwt) throws UserException{
        User userByJwt = userService.findUserProfileByJwt(jwt);
        User followedUser = userService.followUser(userId,userByJwt);
        UserDto userDto = UserDtoMapper.toUserDto(followedUser);
        userDto.setFollowed(UserUtil.isFollowedByReqUser(userByJwt,followedUser));

        return new ResponseEntity<>(userDto, HttpStatus.ACCEPTED);
    }
}
