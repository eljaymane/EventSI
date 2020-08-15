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

import fr.miage.orleans.modele.Event;
import fr.miage.orleans.museeapi.dao.EventRepository;

@RestController
@CrossOrigin
@RequestMapping(value = "/", produces = "application/json")
public class EventController {
    @Autowired
    EventRepository eventRepository;
    
    @PostMapping("/addEvent")
    public ResponseEntity<Event> createEvent(@RequestBody Event event){
        List<Event> existingEvent = EventRepository.findByEventName(event.getEventName());

        if(existingEvent.size() > 0) {
            return new ResponseEntity<Event>((Event)null,HttpStatus.CONFLICT);
        } else {
            eventRepository.save(event);
        }

        return new ResponseEntity<Event>(event,HttpStatus.CREATED);
    }

    //Read
    @GetMapping("/Event/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable long id) {
        if(eventRepository.findById(id) != null){
            Event Event = eventRepository.getOne(id);
            return new ResponseEntity<Event>(Event,HttpStatus.OK);
        }
        return new ResponseEntity<Event>((Event)null,HttpStatus.NOT_FOUND);
          
    }

    //Update
    public ResponseEntity<Event> updateEvent(@RequestBody Event event){
        if(eventRepository.findById(event.getId())!= null){
            eventRepository.save(event);
            return new ResponseEntity<Event>(event,HttpStatus.OK);
        }
        return new ResponseEntity<Event>((Event)null,HttpStatus.NOT_FOUND);
    }

    //Delete
    @DeleteMapping("/Event/{id}")
    public ResponseEntity deleteEvent(@PathVariable long id) {
        Optional<Event> Event = eventRepository.findById(id);
        if(Event != null){
            eventRepository.delete(Event.get());
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    
}