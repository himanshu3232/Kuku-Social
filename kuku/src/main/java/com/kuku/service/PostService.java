package com.kuku.service;

import com.kuku.exception.PostException;
import com.kuku.exception.UserException;
import com.kuku.model.Posts;
import com.kuku.model.User;
import com.kuku.request.PostReplyReq;

import java.util.List;


public interface PostService {
    Posts createPost(Posts post, User user) throws UserException;
    List<Posts> findAllPosts();
    Posts repost(Long id, User user) throws UserException, PostException;
    Posts findById(Long id) throws PostException;
    void deletePost(Long postId, Long userId) throws PostException, UserException;
    //Posts removeFromRepost(Long postId, User user) throws PostException, UserException;
    Posts postReply(PostReplyReq req, User user) throws PostException;
    List<Posts> getUserPosts(User user);
    List<Posts> findByLikesContainsUser(User user);
}
