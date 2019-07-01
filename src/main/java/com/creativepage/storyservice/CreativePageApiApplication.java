package com.creativepage.storyservice;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CreativePageApiApplication {

	@Bean
	public DBObject getDBObject(){
		return new BasicDBObject();
	}

	public static void main(String[] args) {
		SpringApplication.run(CreativePageApiApplication.class, args);
	}

}
