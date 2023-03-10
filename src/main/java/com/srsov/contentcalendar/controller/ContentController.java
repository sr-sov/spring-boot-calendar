package com.srsov.contentcalendar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.srsov.contentcalendar.model.Content;
import com.srsov.contentcalendar.repository.ContentCollectionRepository;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {
	private final ContentCollectionRepository repository;
    
    public ContentController(ContentCollectionRepository contentCollectionRepository) {  
        this.repository = contentCollectionRepository;     
    }
    
    @GetMapping("")
    public List<Content> findAll(){
    	return repository.findAll();
    }
    
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
    	return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found..."));
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Content content) {
    	repository.save(content);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {
    	if(!repository.existsById(id)) {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found...");
    	}
    	repository.save(content);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	repository.delete(id);
    }
    
    
}