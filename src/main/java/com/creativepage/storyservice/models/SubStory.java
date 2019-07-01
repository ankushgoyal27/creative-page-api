package com.creativepage.storyservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SubStory {

    private String imageURL;
    private String description;

}
