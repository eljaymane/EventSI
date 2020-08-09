package fr.miage.orleans.museeapi.dao;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.miage.orleans.modele.Country;

public interface CountryRepository extends JpaRepository<Country,Long> {
    
}