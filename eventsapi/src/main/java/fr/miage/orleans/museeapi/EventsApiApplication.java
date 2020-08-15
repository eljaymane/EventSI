package fr.miage.orleans.museeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@EnableDiscoveryClient
@SpringBootApplication
@EntityScan("fr.miage.orleans.modele")
public class EventsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventsApiApplication.class, args);
    }

}
