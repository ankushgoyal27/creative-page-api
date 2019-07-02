package com.creativepage.storyservice.resources;


import com.creativepage.storyservice.models.Author;
import com.creativepage.storyservice.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/author")
public class AuthorResource {

    @Autowired
    private AuthorService authorService;


    @RequestMapping(method = RequestMethod.GET, value = "/{userName}")
    public Author getAuthor(@PathVariable("userName") String userName){
        return authorService.getAuthor(userName);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addStory(@RequestBody Author author) throws FileNotFoundException {
        authorService.addStory(author);
    }
}
