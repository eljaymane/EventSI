package fr.miage.orleans.museeapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.miage.orleans.museeapi.dao.EventRepository;

@RestController
@CrossOrigin
@RequestMapping(value = "/", produces = "application/json")
public class EventController {
    
    @Autowired
    private EventRepository eventRepository;
    
}