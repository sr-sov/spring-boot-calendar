package com.srsov.contentcalendar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srsov.contentcalendar.model.Content;
import com.srsov.contentcalendar.repository.ContentCollectionRepository;

@RestController
@RequestMapping("/api/content")
public class ContentController {
	private final ContentCollectionRepository repository;
    
    public ContentController(ContentCollectionRepository contentCollectionRepository) {  
        this.repository = contentCollectionRepository;     
    }
    
    @GetMapping("")
    public List<Content> findAll(){
    	return repository.findAll();
    }
}