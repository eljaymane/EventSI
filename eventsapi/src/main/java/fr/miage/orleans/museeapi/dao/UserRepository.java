package fr.miage.orleans.museeapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.miage.orleans.modele.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}