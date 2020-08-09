package fr.miage.orleans.auth_service.DAO;

import fr.miage.orleans.auth_service.Entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role,Integer> {

    Role findByName(String name);
}
