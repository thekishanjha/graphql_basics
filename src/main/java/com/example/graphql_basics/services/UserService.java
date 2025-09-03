package com.example.graphql_basics.services;

import com.example.graphql_basics.entities.User;
import com.example.graphql_basics.helper.ExceptionHelper;
import com.example.graphql_basics.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    //creating a user
    public User createUser(User user){
        return userRepo.save(user);
    }
    //getting all users
    public List<User> getAllUser(){
        return userRepo.findAll();
    }
    //getting a user by id
    public User getUserById(int userId){
        User user1 = userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        return user1;
    }
    //updating a user
    public User updateUser(int userId){
        User user1 = userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        return userRepo.save(user1);
    }
    //deleting a user
    public boolean deleteUser(int userId){
        User user1 = userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        userRepo.delete(user1);
        return true;
    }
}
