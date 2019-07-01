package com.creativepage.storyservice.models;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Story {

	 private String title;
	 private List<SubStory> subStories;
	 private Date timestamp;
}
