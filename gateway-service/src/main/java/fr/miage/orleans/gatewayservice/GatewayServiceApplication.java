package fr.miage.orleans.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r-> r.path("/api/musee/**")
                        .filters(f-> f.rewritePath("/api/musee/(?<remains>.*)","/${remains}"))
                        .uri("lb://musee-api/")
                        .id("museeAPI")
                )
                .route(r->r.path("/api/auth/**")
                        .filters(f-> f.rewritePath("/api/auth/(?<remains>.*)","/${remains}"))
                        .uri("lb://auth-service/")
                        .id("authService")
                ).build();
    }
}
