package com.luciano.felipe.arqcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ArqCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArqCrudApplication.class, args);
	}

}
