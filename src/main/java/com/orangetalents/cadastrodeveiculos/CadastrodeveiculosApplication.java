package com.orangetalents.cadastrodeveiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CadastrodeveiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastrodeveiculosApplication.class, args);
	}

}
