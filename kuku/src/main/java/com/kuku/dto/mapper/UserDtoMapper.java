package com.kuku.dto.mapper;

import com.kuku.dto.UserDto;
import com.kuku.model.User;

import java.util.ArrayList;
import java.util.List;


public class UserDtoMapper {
    public static UserDto toUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setBio(user.getBio());
        userDto.setLocation(user.getLocation());
        userDto.setImage(user.getImage());
        userDto.setBgImg(user.getBgImg());
        userDto.setBirthdate(user.getBirthDate());
        userDto.setWebsite(user.getWebsite());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getFullName());
        userDto.setFollowers(toUserDtos(user.getFollowers()));
        userDto.setFollowing(toUserDtos(user.getFollowings()));
        userDto.setLoginWithGoogle((user.isLogin_with_google()));
        //userDto.setVerified(false);
        return userDto;
    }

    private static List<UserDto> toUserDtos(List<User> followers) {
        List<UserDto> list = new ArrayList<>();
        for(User user : followers){
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setImage(user.getImage());
            userDto.setName(user.getFullName());
            userDto.setEmail(user.getEmail());
            list.add(userDto);
        }
        return list;
    }

}
