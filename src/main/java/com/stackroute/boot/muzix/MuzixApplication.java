package com.stackroute.boot.muzix;

import com.stackroute.boot.muzix.repository.TrackRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = TrackRepository.class)
public class MuzixApplication {

	public static void main(String[] args) {
		SpringApplication application=new SpringApplication(MuzixApplication.class);
		application.addListeners(new MyListener());
		application.run( "agha","sabya");
		System.out.println("server error path  ${error.path:/error}");
	}
}
