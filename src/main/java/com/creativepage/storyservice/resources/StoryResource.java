package com.creativepage.storyservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.creativepage.storyservice.models.Story;
import com.creativepage.storyservice.services.StoryService;

@RestController
@RequestMapping("/stories")
public class StoryResource {
	
	@Autowired
	private StoryService storyService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Story> getAllStories(){
		return storyService.getAllStories();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void addStory(@RequestBody Story story){
		storyService.addStory(story);
	}
	
	
}
