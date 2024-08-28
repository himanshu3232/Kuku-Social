package com.kuku.dto.mapper;

import com.kuku.dto.LikeDto;
import com.kuku.dto.PostDto;
import com.kuku.dto.UserDto;
import com.kuku.model.Likes;
import com.kuku.model.User;

import java.util.ArrayList;
import java.util.List;

public class LikeDtoMapper {
    public static LikeDto toLikeDto(Likes like, User reqUser){
        UserDto user = UserDtoMapper.toUserDto(like.getUser());
        PostDto postDto = PostDtoMapper.toPostDto(like.getPosts(),reqUser);
        LikeDto likeDto = new LikeDto();
        likeDto.setId(like.getId());
        likeDto.setPost(postDto);
        likeDto.setUser(user);

        return likeDto;
    }
    public static List<LikeDto> toLikeDtos(List<Likes> likes, User reqUser){
        List<LikeDto> likeDtos = new ArrayList<>();
        for(Likes like : likes){
            UserDto user = UserDtoMapper.toUserDto(like.getUser());
            PostDto postDto = PostDtoMapper.toPostDto(like.getPosts(),reqUser);

            LikeDto likeDto = new LikeDto();
            likeDto.setId(like.getId());
            likeDto.setPost(postDto);
            likeDto.setUser(user);

            likeDtos.add(likeDto);
        }

        return likeDtos;
    }
}
