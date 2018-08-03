package com.microservice.demo.web;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.demo.model.Bookmark;

@RestController
@RequestMapping("/bookmarkRestTemplate")
public class BookmarkClientRestTemplateRestController {
	
	private RestTemplate restTemplate;

	@Autowired	
	public BookmarkClientRestTemplateRestController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@RequestMapping("/{userId}/bookmarks")
	public Collection<Bookmark> getContactsByUserId(){		  
		  ParameterizedTypeReference<List<Bookmark>> responseType = new ParameterizedTypeReference<List<Bookmark>>(){};
	      ResponseEntity<List<Bookmark>> exchange = this.restTemplate.exchange(
	                "http://bookmark-service/{userId}/bookmarks",
	                HttpMethod.GET, null, responseType, (Object) "pwebb");
	        exchange.getBody().forEach(System.out::println);
	        return exchange.getBody();
	}

}
