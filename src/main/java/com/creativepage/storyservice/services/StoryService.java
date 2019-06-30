package com.creativepage.storyservice.services;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creativepage.storyservice.models.Story;
import com.creativepage.storyservice.repository.StoryRepository;

@Service
public class StoryService {
	
	@Autowired
	private StoryRepository storyRepository;
	
	public List<Story> getAllStories(){
		List<Story> stories = storyRepository.findAll();
		return stories;
	}
	
	public void addStory(Story story) {
		storyRepository.save(story);
	}
	
}
