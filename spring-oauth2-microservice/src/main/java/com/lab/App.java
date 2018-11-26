package com.lab;


import com.lab.model.ProductItem;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableOAuth2Sso
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
