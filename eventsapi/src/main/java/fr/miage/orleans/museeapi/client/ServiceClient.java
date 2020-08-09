package fr.miage.orleans.museeapi.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.miage.orleans.museeapi.DTO.UserDTO;
import fr.miage.orleans.museeapi.Entities.User;
import net.minidev.json.JSONObject;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.Initializable;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public class ServiceClient implements IServiceClient {

    private final String username = "system";
    private final String password ="system";
    private String token="";
    ClientConfig clientConfig = new ClientConfig();
    Client client = ClientBuilder.newClient(clientConfig);
    WebTarget webtarget;


    @Override
    public String authenticate() throws JsonProcessingException {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        userDTO.setPassword(password);
        webtarget = client.target("http://localhost:10002/").path("authenticate");
        Response response = webtarget.request(APPLICATION_JSON).post(Entity.entity(userDTO,MediaType.APPLICATION_JSON));
        JsonNode parent= new ObjectMapper().readTree(response.readEntity(String.class));
        return parent.path("token").asText();
    }

    @Override
    public User findbyUsername(String username) throws JsonProcessingException {
        webtarget = client.target("http://localhost:10002/system/").path("user/"+username);
        User response = webtarget.request().header("Authorization","Bearer "+ token).accept(APPLICATION_JSON).get(User.class);
        ObjectMapper mapper = new ObjectMapper();
        return response;
    }

    public ServiceClient() {
        if(token == "") {
            try {
                token = authenticate();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

}
