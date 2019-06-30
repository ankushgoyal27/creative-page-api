package com.creativepage.storyservice.repository;

import com.creativepage.storyservice.models.Story;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoryRepository extends MongoRepository<Story, Long> {

}
