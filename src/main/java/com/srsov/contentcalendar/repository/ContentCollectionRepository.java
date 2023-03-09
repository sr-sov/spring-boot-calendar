package com.srsov.contentcalendar.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.srsov.contentcalendar.model.Content;
import com.srsov.contentcalendar.model.Type;

import jakarta.annotation.PostConstruct;

import com.srsov.contentcalendar.model.Status;

@Repository
public class ContentCollectionRepository {
	//keep a collection of Content in-memory; not database yet
	
	private final List<Content> contentList = new ArrayList<Content>();
	
	public ContentCollectionRepository() {	
	}
	
	public List<Content> findAll() {
		return contentList;
	}
	
	public Optional<Content> findById(Integer id){
	//Optional: may or may not contain a null value
		return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
	}
	
	public void save(Content content) {
		contentList.add(content);
	}
	
	@PostConstruct
	private void init() {
		Content c = new Content(1,
				"My First Blog Post",
				"blog post",
				Status.IDEA,
				Type.ARTICLE,
				LocalDateTime.now(),
				null,
				"");
		contentList.add(c);
	}
	
	
}
