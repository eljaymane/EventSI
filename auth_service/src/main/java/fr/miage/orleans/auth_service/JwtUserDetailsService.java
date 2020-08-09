package fr.miage.orleans.auth_service;

import fr.miage.orleans.auth_service.DAO.RoleDao;
import fr.miage.orleans.auth_service.DAO.UserDao;
import fr.miage.orleans.auth_service.DTO.UserDTO;
import fr.miage.orleans.auth_service.Entities.Role;
import fr.miage.orleans.auth_service.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                getAuthorities(user));
    }

    public User save(UserDTO user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
       /* newUser.setPrenom(user.getPrenom());
        newUser.setNom(user.getNom());
        newUser.setEmail(user.getEmail());*/
        List<Role> roles = new ArrayList<>();
        roles.add(roleDao.findByName("ROLE_USER"));
        newUser.setRoles(roles);
        return userDao.save(newUser);
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
}