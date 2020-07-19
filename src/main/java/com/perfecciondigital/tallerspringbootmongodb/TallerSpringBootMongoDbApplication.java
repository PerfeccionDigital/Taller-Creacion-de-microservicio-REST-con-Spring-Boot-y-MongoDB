package com.perfecciondigital.tallerspringbootmongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class TallerSpringBootMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerSpringBootMongoDbApplication.class, args);
	}

}
