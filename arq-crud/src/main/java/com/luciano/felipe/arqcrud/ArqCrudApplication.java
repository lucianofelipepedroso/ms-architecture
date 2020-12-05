package com.luciano.felipe.arqcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ArqCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArqCrudApplication.class, args);
	}

}
