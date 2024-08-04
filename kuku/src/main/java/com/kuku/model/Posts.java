package com.kuku.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String content;

    private String image;

    private String video;

    @OneToMany(mappedBy = "posts", cascade = CascadeType.ALL)
    private List<Likes> likes = new ArrayList<>();

    @OneToMany
    private List<Posts> replies = new ArrayList<>();

    @ManyToMany
    private List<User> reposts = new ArrayList<>();

    @ManyToOne
    private Posts replyFor;

    private boolean isReply;

    private boolean isPost;


}
