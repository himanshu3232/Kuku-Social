package com.kuku.request.impl;

import com.kuku.exception.PostException;
import com.kuku.exception.UserException;
import com.kuku.model.Posts;
import com.kuku.model.User;
import com.kuku.repository.PostRepo;
import com.kuku.request.PostReplyReq;
import com.kuku.service.PostService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Override
    public Posts createPost(Posts req, User user) throws UserException {
        Posts post = new Posts();
        post.setContent(req.getContent());
        post.setCreatedAt(LocalDateTime.now());
        post.setImage(req.getImage());
        post.setUser(user);
        post.setReply(false);
        post.setPost(true);
        post.setVideo(req.getVideo());

        return postRepo.save(post);
    }

    @Override
    public List<Posts> findAllPosts() {

        return postRepo.findAllByIsPostTrueOrderByCreatedAtDesc();
    }

    @Override
    public Posts repost(Long id, User user) throws UserException, PostException {
        Posts post = findById(id);
        if(post.getReposts().contains(user)){
            post.getReposts().remove(user);
        }else post.getReposts().add(user);

        return postRepo.save(post);
    }

    @Override
    public Posts findById(Long id) throws PostException {
        return postRepo.findById(id)
                .orElseThrow(() -> new PostException("Post does not exists with id: " + id));
    }

    @Override
    public void deletePost(Long postId, Long userId) throws PostException, UserException {
        Posts post = findById(postId);

        if(!userId.equals(post.getUser().getId())){
            throw new UserException("You can't delete another User's post");
        }

        postRepo.deleteById(post.getId());
    }

    @Override
    public Posts postReply(PostReplyReq req, User user) throws PostException {
        Posts replyFor = findById(req.getPostId());
        Posts post = new Posts();
        post.setContent(req.getContent());
        post.setCreatedAt(LocalDateTime.now());
        post.setImage(req.getImage());
        post.setUser(user);
        post.setReply(true);
        post.setPost(false);
        post.setReplyFor(replyFor);

        Posts savedReply = postRepo.save(post);

        post.getReplies().add(savedReply);
        postRepo.save(replyFor);

        return replyFor;
    }

    @Override
    public List<Posts> getUserPosts(User user) {
        return postRepo.findByRepostsContainsOrUser_IdAndIsPostTrueOrderByCreatedAtDesc(user,user.getId());
    }

    @Override
    public List<Posts> findByLikesContainsUser(User user) {
        return postRepo.findByLikesUser_id(user.getId());
    }
}
