package com.creativepage.storyservice.repository;

import com.creativepage.storyservice.models.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, Long> {
    Author findByUserName(String userName);
}