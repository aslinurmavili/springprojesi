package com.asli.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringProjesiOlusturmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjesiOlusturmaApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(MessageService messageService) {
		return args -> {
			messageService.sendMessage();
		};
	}
}

