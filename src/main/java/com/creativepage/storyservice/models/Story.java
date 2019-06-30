package com.creativepage.storyservice.models;

import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Story {

	@Id
	@Getter @Setter private long storyId;
	@Getter @Setter private String title;
	@Getter @Setter private Set<String> imageURL;
	@Getter @Setter private String description;
	@Getter @Setter private Date timestamp;
}
