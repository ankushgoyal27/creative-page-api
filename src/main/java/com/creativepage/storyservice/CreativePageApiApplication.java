package com.creativepage.storyservice;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CreativePageApiApplication {

	@Bean
	public DBObject getDBObject(){
		return new BasicDBObject();
	}

	@Bean
	public MongoDatabase getMongoDatabase(){
		MongoClient mongoClient = MongoClients.create();
		return mongoClient.getDatabase("Story");
	}

	public static void main(String[] args) {
		SpringApplication.run(CreativePageApiApplication.class, args);
	}

}
