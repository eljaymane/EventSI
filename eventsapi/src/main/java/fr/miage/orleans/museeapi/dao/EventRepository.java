package fr.miage.orleans.museeapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.miage.orleans.modele.Event;

public interface EventRepository extends JpaRepository<Event,Long> {
    
}