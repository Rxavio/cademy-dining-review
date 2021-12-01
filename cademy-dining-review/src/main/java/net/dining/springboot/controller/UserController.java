package net.dining.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.dining.springboot.model.User;
import net.dining.springboot.repository.UserRepository;


@RestController
//@RequestMapping("api/v1")
public class UserController {
//    @Autowired
//    UserRepository userRepository;
	
	private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users/adduser")
    public User createNewUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }
    
    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();

    }
    
    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable("id") Long id) {
        Optional<User> optionalUser = this.userRepository.findById(id);

        if(optionalUser.isEmpty()) {
            return null;
        }
        User userToDelete = optionalUser.get();
        this.userRepository.delete(userToDelete);
        return userToDelete;
    }

  }
