package fr.miage.orleans.museeapi;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.core.JsonProcessingException;
import fr.miage.orleans.museeapi.Entities.User;
import fr.miage.orleans.museeapi.client.ClientSingleton;
import fr.miage.orleans.museeapi.client.ServiceClient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class JwtUserDetailsService implements UserDetailsService {


    private ServiceClient client = ClientSingleton.getInstance();
    
    public JwtUserDetailsService() {
    	
    }

    @Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        try {
            user = client.findbyUsername(username);
            user.setPassword("x");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                getAuthorities(user));
}

    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
}