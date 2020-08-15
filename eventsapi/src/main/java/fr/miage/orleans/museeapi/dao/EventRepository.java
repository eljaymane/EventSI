package fr.miage.orleans.museeapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.miage.orleans.modele.Event;

public interface EventRepository extends JpaRepository<Event,Long> {

	static List<Event> findByEventName(String eventName) {
		return null;
	}
    
}