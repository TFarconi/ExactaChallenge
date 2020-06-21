package com.controle.gastos.gastosservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GastosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GastosServiceApplication.class, args);
	}

}
