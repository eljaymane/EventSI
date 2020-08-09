package fr.miage.orleans.auth_service.Controllers;

import fr.miage.orleans.auth_service.DAO.UserDao;
import fr.miage.orleans.auth_service.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value="/system")
public class SystemController {
    @Autowired
    UserDao userDao;

    @GetMapping(value="/user/{username}")
    public User findByUsername(@PathVariable(value="username") String username){

        return userDao.findByUsername(username);
    }
}
