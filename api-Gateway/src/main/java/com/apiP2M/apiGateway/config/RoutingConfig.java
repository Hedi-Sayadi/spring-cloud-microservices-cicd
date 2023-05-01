package com.apiP2M.apiGateway.config;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class RoutingConfig {

    @Bean

    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("ratings-data-id", r -> r.path("/ratingsdata/**").uri("lb://RATING-DATA-SERVICE"))
                .route("movie-catalog-id", r -> r.path("/catalog/**").uri("lb://MOVIE-CATALOG-SERVICE"))
                .route("movie-info-id", r -> r.path("/movies/**").uri("lb://MOVIE-INFO-SERVICE"))
                .build();
    }
}