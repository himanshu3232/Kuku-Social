package com.kuku.dto;

import lombok.Data;
import java.util.List;
import java.time.LocalDateTime;

@Data
public class PostDto {
    private Long id;
    private String content;
    private String image;
    private String video;
    private UserDto user;
    private LocalDateTime createdAt;
    private int totalLikes;
    private int totalReplies;
    private int totalReposts;
    private boolean isLiked;
    private boolean isRepost;
    private List<Long> repostUsersId;
    private List<PostDto> replyPosts;
}
