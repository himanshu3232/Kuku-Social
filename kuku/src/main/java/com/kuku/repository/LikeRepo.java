package com.kuku.repository;

import com.kuku.model.Likes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeRepo extends CrudRepository<Likes,Long> {

    @Query("SELECT L FROM Likes L WHERE L.user.id =: userId AND L.posts.id =: postId")
    Likes isLikeExist(@Param("userId") Long userId, @Param("postId") Long postId);

    @Query("SELECT L FROM Likes L WHERE L.posts.id =: postId")
    public List<Likes> findByPostId(@Param("postId") Long postId);
}
