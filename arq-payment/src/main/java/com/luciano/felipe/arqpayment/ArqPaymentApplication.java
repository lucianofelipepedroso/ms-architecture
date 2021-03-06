package com.luciano.felipe.arqpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ArqPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArqPaymentApplication.class, args);
	}

}
