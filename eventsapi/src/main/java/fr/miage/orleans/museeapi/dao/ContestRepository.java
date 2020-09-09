package fr.miage.orleans.museeapi.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.miage.orleans.modele.Contest;

public interface ContestRepository extends JpaRepository<Contest,Long> {
	
	

}
