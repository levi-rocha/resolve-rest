package com.example.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {
        "com.example.myapp"
		  })
@EnableJpaRepositories(basePackages = {
		  "com.example.myapp"
		  })
@ComponentScan(basePackages = {"com.example.myapp"})
public class Application {

  public static void main(String[] args) {
	  SpringApplication.run(Application.class, args);    
  }
}