package fr.miage.orleans.museeapi.controllers;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.miage.orleans.modele.Contest;
import fr.miage.orleans.modele.Country;
import fr.miage.orleans.museeapi.dao.ContestRepository;
import fr.miage.orleans.museeapi.dao.CountryRepository;

@RestController
@CrossOrigin
@RequestMapping(value ="/", produces = "application/json")
public class ContestController {
	@Autowired
    private ContestRepository contestRepository;
	
	//Read
    @GetMapping("/contests")
    public ResponseEntity<ArrayList<Contest>> getCountry() {
    	
            return new ResponseEntity<ArrayList<Contest>>((ArrayList<Contest>) contestRepository.findAll(),HttpStatus.OK);
            
    }

}
