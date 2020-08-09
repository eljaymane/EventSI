package fr.miage.orleans.auth_service.DAO;

import fr.miage.orleans.auth_service.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
