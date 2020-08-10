package fr.miage.orleans.museeapi.controllers;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;

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
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import fr.miage.orleans.modele.Country;
import fr.miage.orleans.modele.User;
import fr.miage.orleans.museeapi.dao.CountryRepository;
import fr.miage.orleans.museeapi.dao.UserRepository;

@RestController
@CrossOrigin
@RequestMapping(value ="/", produces = "application/json")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    //Create
    @PostMapping("/addCountry")
    public ResponseEntity<Country> createCountry(@RequestBody Country country){
        List<Country> existingCountry = countryRepository.findByCountryName(country.getCountryName());

        if(existingCountry.size() > 0) {
            return new ResponseEntity<Country>((Country)null,HttpStatus.CONFLICT);
        } else {
            countryRepository.save(country);
        }

        return new ResponseEntity<Country>(country,HttpStatus.CREATED);
    }

    //Read
    @GetMapping("/country/{id}")
    public ResponseEntity<Country> getCountry(@PathVariable long id) {
        if(countryRepository.findById(id) != null){
            Country country = countryRepository.getOne(id);
            return new ResponseEntity<Country>(country,HttpStatus.OK);
        }
        return new ResponseEntity<Country>((Country)null,HttpStatus.NOT_FOUND);
          
    }

    //Update
    public ResponseEntity<Country> updateCountry(@RequestBody Country country){
        if(countryRepository.findById(country.getId())!= null){
            countryRepository.save(country);
            return new ResponseEntity<Country>(country,HttpStatus.OK);
        }
        return new ResponseEntity<Country>((Country)null,HttpStatus.NOT_FOUND);
    }

    //Delete
    @DeleteMapping("/country/{id}")
    public ResponseEntity deleteCountry(@PathVariable long id) {
        Optional<Country> country = countryRepository.findById(id);
        if(country != null){
            countryRepository.delete(country.get());
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    
}