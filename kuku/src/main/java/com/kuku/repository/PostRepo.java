package com.kuku.repository;

import com.kuku.model.Posts;
import com.kuku.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepo extends CrudRepository<Posts,Long> {


    List<Posts> findAllByIsPostTrueOrderByCreatedAtDesc();

    List<Posts> findByRepostsContainsOrUser_IdAndIsPostTrueOrderByCreatedAtDesc(User user, Long userId);

    List<Posts> findByLikesContainingOrderByCreatedAtDesc(User user);

    @Query("SELECT P FROM Posts P JOIN P.likes L WHERE L.user.id =: userId")
    List<Posts> findByLikesUser_id(Long userId);
}
