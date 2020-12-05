package com.luciano.felipe.arqpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ArqPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArqPaymentApplication.class, args);
	}

}
