package fr.miage.orleans.auth_service.Controllers;

import fr.miage.orleans.auth_service.DAO.RoleDao;
import fr.miage.orleans.auth_service.DAO.UserDao;
import fr.miage.orleans.auth_service.Entities.Role;
import fr.miage.orleans.auth_service.Entities.User;
import fr.miage.orleans.auth_service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin
@RequestMapping(value="/admin")
public class AdminController {
    @Autowired
    RoleDao roleRepository;
    @Autowired
    UserDao userRepository;

    @PostMapping(value ="/roles")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        if(roleRepository.findByName(role.getName()) == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(roleRepository.save(role),HttpStatus.CREATED);
    }

    @PutMapping(value = "/user")
    public ResponseEntity<User> updateRoles(@RequestBody User u,@RequestBody String roleNames[]){
        if(userRepository.findByUsername(u.getUsername()) == null) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        for (String name: roleNames) {
            Role r = roleRepository.findByName(name);
            if(r!=null){
                u.getRoles().add(r);
            }
            ;

        }
        return new ResponseEntity<>(userRepository.save(u),HttpStatus.OK);
    }


}
