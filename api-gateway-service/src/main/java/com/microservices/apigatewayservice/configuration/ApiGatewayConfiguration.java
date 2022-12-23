package com.microservices.apigatewayservice.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
    

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(p -> p.path("/get")
                    .filters(f -> f
                            .addRequestHeader("MyHeader", "MyURI"))
                            .uri("http://httpbin.org:80"))
            .route(f -> f.path("/api/v1/currency-exchange/**")
                        .uri("lb://currency-exchange"))
            .route(f -> f.path("/api/v1/currency-conversion/**")
                        .uri("lb://currency-conversion"))
            .route(f -> f.path("/api/v1/currency-conversion/feign/**")
                        .uri("lb://currency-conversion"))      
            .build();
    }
}
