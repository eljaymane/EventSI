package fr.miage.orleans.museeapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import fr.miage.orleans.modele.User;
import fr.miage.orleans.museeapi.dao.UserRepository;

@RestController
@RequestMapping(value = "/", produces = "application/json")
@CrossOrigin
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private String authUrl = "http://localhost:10002";
    
    
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        List<User> existingUser = userRepository.findByUsername(user.getUsername());

        if(existingUser.size() > 0) {
            return new ResponseEntity<User>((User)null,HttpStatus.CONFLICT);
        } else {
        	userRepository.save(user);
        	//register(user.getUsername(),user.getPassword(),user.getEmail());
            
        }

        return new ResponseEntity<User>(user,HttpStatus.CREATED);
    }

    //Read
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        if(userRepository.findById(id) != null){
            User user = userRepository.getOne(id);
            return new ResponseEntity<User>(user,HttpStatus.OK);
        }
        return new ResponseEntity<User>((User)null,HttpStatus.NOT_FOUND);
          
    }

    //Update
    public ResponseEntity<User> updateUser(@RequestBody User user){
        if(userRepository.findById(user.getId())!= null){
            userRepository.save(user);
            return new ResponseEntity<User>(user,HttpStatus.OK);
        }
        return new ResponseEntity<User>((User)null,HttpStatus.NOT_FOUND);
    }

    //Delete
    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUser(@PathVariable long id) {
        Optional<User> User = userRepository.findById(id);
        if(User.get() != null){
            userRepository.delete(User.get());
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    
}