package br.unifor.resolve.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {
        "br.unifor.resolve.rest"
		  })
@EnableJpaRepositories(basePackages = {
		  "br.unifor.resolve.rest"
		  })
@ComponentScan(basePackages = {"br.unifor.resolve.rest"})
public class Application {

  public static void main(String[] args) {
	  SpringApplication.run(Application.class, args);    
  }
}