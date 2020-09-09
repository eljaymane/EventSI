package fr.miage.orleans.museeapi.controllers;

import java.util.ArrayList;
import java.util.Collection;
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

import fr.miage.orleans.modele.Rank;
import fr.miage.orleans.museeapi.dao.RankRepository;

@RestController
@RequestMapping(value ="/", produces = "application/json")
@CrossOrigin
public class RankController {
    @Autowired 
    private RankRepository rankRepository;

    @PostMapping("/addRank")
    public ResponseEntity<Rank> createRank(@RequestBody Rank rank){
    	Collection<Rank> existingRank = new ArrayList<>();
        existingRank = RankRepository.findByRankName(rank.getRankName());
        
        if(existingRank!= null) {
        if(existingRank.size() > 0) {
           //Fail first
        } else {
            rankRepository.save(rank);
            return new ResponseEntity<Rank>(rank,HttpStatus.CREATED);
        }
        }

        return new ResponseEntity<Rank>((Rank)null,HttpStatus.CONFLICT);
    }

    //Read
    @GetMapping("/Rank/{id}")
    public ResponseEntity<Rank> getRank(@PathVariable long id) {
        if(rankRepository.findById(id) != null){
            Rank rank = rankRepository.getOne(id);
            return new ResponseEntity<Rank>(rank,HttpStatus.OK);
        }
        return new ResponseEntity<Rank>((Rank)null,HttpStatus.NOT_FOUND);
          
    }

    //Update
    public ResponseEntity<Rank> updateRank(@RequestBody Rank rank){
        if(rankRepository.findById(rank.getId())!= null){
            rankRepository.save(rank);
            return new ResponseEntity<Rank>(rank,HttpStatus.OK);
        }
        return new ResponseEntity<Rank>((Rank)null,HttpStatus.NOT_FOUND);
    }

    //Delete
    @DeleteMapping("/Rank/{id}")
    public ResponseEntity deleteRank(@PathVariable long id) {
        Optional<Rank> rank = rankRepository.findById(id);
        if(rank.get() != null){
            rankRepository.delete(rank.get());
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    
}