package org.example.s9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class S9Application {

	public static void main(String[] args) {
		SpringApplication.run(S9Application.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
						.route("Product", r->r.path("/product/**").uri("http://localhost:8081/"))
						.route("Reviews", r->r.path("/reviews/**").uri("http://localhost:8082/"))
						.route("Cart", r->r.path("/cart/**").uri("http://localhost:8083/")).build();

	}
}
