package com.microservice.demo.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.demo.model.Bookmark;
import com.microservice.demo.repository.BookmarkRepository;

@RestController
public class BookmarkRestController {
	
	@Value("${message}")
	private String message;
	
	private BookmarkRepository bookmarkRepository;
	
	@Autowired
	public BookmarkRestController(BookmarkRepository bookmarkRepository) {
		this.bookmarkRepository = bookmarkRepository;
	}
	
	
	@RequestMapping("/{userId}/bookmarks")
	public Collection<Bookmark> getBookmarksByUserId(@PathVariable String userId){
		return this.bookmarkRepository.findByUserId(userId);
	}
	
	@RequestMapping("/message")
	public String getMessage(){
		return this.message;
	}

}
