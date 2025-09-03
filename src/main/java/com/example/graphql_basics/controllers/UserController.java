package com.example.graphql_basics.controllers;

import com.example.graphql_basics.entities.User;
import com.example.graphql_basics.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    //create user API
    @MutationMapping
    public User createUser(@Argument String name, @Argument String phone, @Argument String email, @Argument String password){
        User user1 = new User();
        user1.setName(name);
        user1.setPhone(phone);
        user1.setEmail(email);
        user1.setPassword(password);
        return userService.createUser(user1);
    }

    @QueryMapping(name = "getUsers")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @QueryMapping(name = "getUserById")
    public User getUser(@Argument int userId){
        return userService.getUserById(userId);
    }

    @MutationMapping
    public boolean deleteUser(@Argument int userId){
        return userService.deleteUser(userId);
    }
}
