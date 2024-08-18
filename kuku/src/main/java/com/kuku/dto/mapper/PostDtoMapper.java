package com.kuku.dto.mapper;

import com.kuku.util.PostUtil;
import com.kuku.dto.PostDto;
import com.kuku.dto.UserDto;
import com.kuku.model.Posts;
import com.kuku.model.User;

import java.util.ArrayList;
import java.util.List;

public class PostDtoMapper {
    public static PostDto toPostDto(Posts posts, User user){
        UserDto userDto = UserDtoMapper.toUserDto(posts.getUser());
        boolean isLiked = PostUtil.isLikedByUser(user,posts);
        boolean isReposted = PostUtil.isRepostedByUser(user,posts);

        final List<Long> repostUserId = new ArrayList<>();

        for(User user1 : posts.getReposts()){
            repostUserId.add(user1.getId());
        }

        final PostDto postDto = new PostDto();
        postDto.setId(posts.getId());
        postDto.setContent(posts.getContent());
        postDto.setCreatedAt(posts.getCreatedAt());
        postDto.setImage(posts.getImage());
        postDto.setTotalLikes(posts.getLikes().size());
        postDto.setTotalReplies(posts.getReplies().size());
        postDto.setTotalReposts(posts.getReposts().size());
        postDto.setUser(userDto);
        postDto.setLiked(isLiked);
        postDto.setRepost(isReposted);
        postDto.setRepostUsersId(repostUserId);
        postDto.setReplyPosts(toPostDtos(posts.getReplies(),user));
        postDto.setVideo(posts.getVideo());

        return postDto;

    }

    public static List<PostDto> toPostDtos(List<Posts> posts, User user){
        List<PostDto> list = new ArrayList<>();
        for(Posts post : posts){
            PostDto postDto = toReplyPostDto(post,user);
            list.add(postDto);
        }
        return list;
    }

    private static PostDto toReplyPostDto(Posts posts, User user) {
        UserDto userDto = UserDtoMapper.toUserDto(posts.getUser());
        boolean isLiked = PostUtil.isLikedByUser(user,posts);
        boolean isReposted = PostUtil.isRepostedByUser(user,posts);

        final List<Long> repostUserId = new ArrayList<>();

        for(User user1 : posts.getReposts()){
            repostUserId.add(user1.getId());
        }

        final PostDto postDto = new PostDto();
        postDto.setId(posts.getId());
        postDto.setContent(posts.getContent());
        postDto.setCreatedAt(posts.getCreatedAt());
        postDto.setImage(posts.getImage());
        postDto.setTotalLikes(posts.getLikes().size());
        postDto.setTotalReplies(posts.getReplies().size());
        postDto.setTotalReposts(posts.getReposts().size());
        postDto.setUser(userDto);
        postDto.setLiked(isLiked);
        postDto.setRepost(isReposted);
        postDto.setRepostUsersId(repostUserId);
        postDto.setVideo(posts.getVideo());

        return postDto;
    }
}
