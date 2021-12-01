package net.dining.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import net.dining.springboot.model.User;
import net.dining.springboot.repository.UserRepository;


@RestController
public class UserController {
   @Autowired
    UserRepository userRepository;
	
//	private final UserRepository userRepository;
//
//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

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
        //  return null;
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The user with this id does not exist");
        }
        User userToDelete = optionalUser.get();
        this.userRepository.delete(userToDelete);
        return userToDelete;
    }
    
//    @GetMapping("/users/{id}")
//    public Optional<User> getUserId(@PathVariable("id") Long id) {
//      return this.userRepository.findById(id);
//    }
    
    
    @GetMapping("/users/{userName}")
    public Optional<User> getUserByUsername(@PathVariable("userName") String userName) {
        Optional<User> userOptional = userRepository.findByUserName(userName);
        if(userOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exist");
        }
        return userRepository.findByUserName(userName);
    }
    

  }
