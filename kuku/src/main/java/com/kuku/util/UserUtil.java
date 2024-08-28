package com.kuku.util;


import com.kuku.model.User;

public class UserUtil {
    public static boolean isReqUser(User user1, User user2){
        return user1.getId().equals(user2.getId());
    }

    public static boolean isFollowedByReqUser(User reqUser, User user2){
        return reqUser.getFollowings().contains(user2);
    }
}
