package com.example.Medical.Records.v10.service.user;

import com.example.Medical.Records.v10.data.entity.User;
//import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService // extends UserDetailsService //
{
//    User findUserByUserName(String name);
//
//    User findUserByEmail(String name);


//    UserServiceModel editUserProfile(UserServiceModel userServiceModel, String oldPassword);

    List<User> findAllUsers();


    User findUserById(Long id);

    void deleteUser(User user);
}
