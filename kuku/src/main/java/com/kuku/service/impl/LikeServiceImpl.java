package com.kuku.service.impl;

import com.kuku.exception.PostException;
import com.kuku.exception.UserException;
import com.kuku.model.Likes;
import com.kuku.model.Posts;
import com.kuku.model.User;
import com.kuku.repository.LikeRepo;
import com.kuku.repository.PostRepo;
import com.kuku.service.LikeService;
import com.kuku.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService {

    @Autowired
    private final LikeRepo likeRepo;

    @Autowired
    private final PostService postService;

    @Autowired
    private final PostRepo postRepo;

    @Override
    public Likes likePost(Long postId, User user) throws UserException, PostException {
        Likes isLikeExists = likeRepo.isLikeExist(user.getId(), postId);

        if(isLikeExists != null){
            likeRepo.deleteById(isLikeExists.getId());
            return isLikeExists;
        }
        Posts post = postService.findById(postId);
        Likes like = new Likes();
        like.setPosts(post);
        like.setUser(user);

        Likes savedLike = likeRepo.save(like);
        post.getLikes().add(savedLike);

        postRepo.save(post);
        return savedLike;
    }

    @Override
    public List<Likes> getAllLikes(Long postId) throws PostException {
        Posts post = postService.findById(postId);

        return likeRepo.findByPostId(postId);
    }
}
