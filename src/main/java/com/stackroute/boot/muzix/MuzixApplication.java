package com.stackroute.boot.muzix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class MuzixApplication {

	public static void main(String[] args) {
		SpringApplication application=new SpringApplication(MuzixApplication.class);
		application.addListeners(new MyListener());
		application.run( "agha","sabya");
		System.out.println("server error path  ${error.path:/error}");
	}
}
