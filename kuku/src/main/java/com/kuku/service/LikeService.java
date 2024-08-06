package com.kuku.service;

import com.kuku.exception.PostException;
import com.kuku.exception.UserException;
import com.kuku.model.Likes;
import com.kuku.model.User;

import java.util.List;

public interface LikeService{
    Likes likePost(Long postId, User user) throws UserException, PostException;
    List<Likes> getAllLikes(Long postId) throws PostException;
}
