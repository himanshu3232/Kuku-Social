package com.kuku.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String image;
    private String location;
    private String website;
    private String birthdate;
    private String mobile;
    private String bgImg;
    private String bio;

    //to check if the given user is requested by id
    private boolean req_user;
    private boolean loginWithGoogle;
    private List<UserDto> followers = new ArrayList<>();
    private List<UserDto> following = new ArrayList<>();

    private boolean followed;
    private boolean isVerified;
}
