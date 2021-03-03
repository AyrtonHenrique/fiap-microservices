package br.com.fiap.microservices.easynsurance.corretor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class CorretorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorretorApplication.class, args);
	}

}
