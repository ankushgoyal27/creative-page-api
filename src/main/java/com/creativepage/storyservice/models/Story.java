package com.creativepage.storyservice.models;

import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.Id;

public class Story {

	@Id
	private long storyId;
	private String title;
	private Set<String> imageURL;
	private String description;
	private Date timestamp;
	
	
	public Story() {
		super();
	}
	
	public Story(long storyId, String title, Set<String> imageURL, String description, Date timestamp) {
		super();
		this.storyId = storyId;
		this.title = title;
		this.imageURL = imageURL;
		this.description = description;
		this.timestamp = timestamp;
	}
	
	public long getStoryId() {
		return storyId;
	}
	public void setStoryId(long storyId) {
		this.storyId = storyId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Set<String> getImageURL() {
		return imageURL;
	}
	public void setImageURL(Set<String> imageURL) {
		this.imageURL = imageURL;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Story [storyId=" + storyId + ", title=" + title + ", imageURL=" + imageURL + ", description="
				+ description + ", timestamp=" + timestamp + "]";
	}
	
	
}
