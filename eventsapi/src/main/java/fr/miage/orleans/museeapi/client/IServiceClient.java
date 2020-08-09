package fr.miage.orleans.museeapi.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import fr.miage.orleans.museeapi.Entities.User;

import javax.ws.rs.core.Response;
import java.util.List;

public interface IServiceClient {


    String authenticate() throws JsonProcessingException;
    User findbyUsername(String username) throws JsonProcessingException;

}
