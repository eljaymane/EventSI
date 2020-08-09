package fr.miage.orleans.museeapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.miage.orleans.museeapi.dao.UserRepository;

@RestController
@RequestMapping(value = "/", produces = "application/json")
@CrossOrigin
public class UserController {
    @Autowired
    private UserRepository userRepository;
    
}