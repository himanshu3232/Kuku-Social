package com.kuku.util;

import com.kuku.model.Likes;
import com.kuku.model.Posts;
import com.kuku.model.User;

public class PostUtil {
    public static boolean isLikedByUser(User user, Posts posts){

        for(Likes like : posts.getLikes()){
            if (like.getUser().getId().equals(user.getId())){
                return true;
            }
        }
        return false;
    }

    public static boolean isRepostedByUser(User reqUser, Posts posts){
        for (User user : posts.getReposts()){
            if(user.getId().equals(reqUser.getId())){
                return true;
            }
        }
        return false;
    }
}
