package com.example.seco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("com.example.seco.model")  
@SpringBootApplication
public class SecoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecoApplication.class, args);
		System.out.println("its ok");
	}

}
