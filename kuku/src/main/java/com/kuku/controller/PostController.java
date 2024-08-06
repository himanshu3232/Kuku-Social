package com.kuku.controller;

import com.kuku.service.PostService;
import com.kuku.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
public class PostController {

    @Autowired
    private final PostService postService;

    @Autowired
    private final UserService userService;
}
