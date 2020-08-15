package fr.miage.orleans.museeapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.miage.orleans.modele.User;

public interface UserRepository extends JpaRepository<User,Long> {

	List<User> findByUsername(String username);
    
}