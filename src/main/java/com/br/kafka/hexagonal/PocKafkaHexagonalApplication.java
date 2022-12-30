package com.br.kafka.hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PocKafkaHexagonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocKafkaHexagonalApplication.class, args);
	}

}
