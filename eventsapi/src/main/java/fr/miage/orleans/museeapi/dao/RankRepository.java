package fr.miage.orleans.museeapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.miage.orleans.modele.Rank;

public interface RankRepository extends JpaRepository<Rank, Long> {
    
}