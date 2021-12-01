package net.dining.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.dining.springboot.model.User;
import net.dining.springboot.repository.UserRepository;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/users/adduser")
    public User createNewUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }
    


  }
