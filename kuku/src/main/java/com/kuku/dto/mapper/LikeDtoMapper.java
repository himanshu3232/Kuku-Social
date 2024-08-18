package com.kuku.dto.mapper;

import com.kuku.dto.LikeDto;
import com.kuku.model.Likes;
import com.kuku.model.User;

public class LikeDtoMapper {
    public static LikeDto toLikeDto(Likes likes, User reqUser){
        LikeDto likeDto = new LikeDto();
        return likeDto;
    }
}
