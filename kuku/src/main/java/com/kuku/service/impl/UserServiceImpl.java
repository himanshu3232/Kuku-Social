package com.kuku.service.impl;

import com.kuku.config.JwtProvider;
import com.kuku.exception.UserException;
import com.kuku.model.User;
import com.kuku.repository.UserRepo;
import com.kuku.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepo userRepo;

    @Autowired
    private final JwtProvider jwtProvider;

    @Override
    public User findUserById(Long userId) throws UserException {
        return userRepo.findById(userId)
                .orElseThrow(() -> new UserException("User not found with id: " + userId));

    }

    @Override
    public User findUserProfileByJwt(String jwt) throws UserException {
        String email = jwtProvider.getEmailFromToken(jwt);
        if(email == null) throw new UserException("User not found with token " + jwt);
        return userRepo.findByEmail(email);
    }

    @Override
    public User updateUser(Long userId, User user) throws UserException {
        User user1 = findUserById(userId);
        if(user.getFullName() != null){
            user1.setFullName(user.getFullName());
        }
        if(user.getImage() != null){
            user1.setImage(user.getImage());
        }
        if(user.getBgImg() != null){
            user1.setBgImg(user.getBgImg());
        }
        if(user.getBirthDate() != null){
            user1.setBirthDate(user1.getBirthDate());
        }
        if(user.getLocation() != null){
            user1.setLocation(user.getLocation());
        }
        if(user.getBio() != null){
            user1.setBio(user.getBio());
        }
        if(user.getWebsite() != null){
            user1.setWebsite(user.getWebsite());
        }
        return userRepo.save(user1);
    }

    @Override
    public User followUser(Long userId, User user) throws UserException {
        User followToUser = findUserById(userId);

        if(user.getFollowings().contains(followToUser)
                && followToUser.getFollowers().contains(user)){
            user.getFollowings().remove(followToUser);
            followToUser.getFollowers().remove(user);
        }else{
            user.getFollowings().add(followToUser);
            followToUser.getFollowers().add(user);
        }
        userRepo.save(followToUser);
        userRepo.save(user);
        return followToUser;
    }

    @Override
    public List<User> searchUser(String query) {
        return userRepo.searchUsers(query);
    }
}
