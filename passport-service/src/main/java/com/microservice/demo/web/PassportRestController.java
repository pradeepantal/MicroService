package com.microservice.demo.web;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.demo.feign.integration.FeignIntegrationClient;
import com.microservice.demo.model.Bookmark;
import com.microservice.demo.model.Contact;
import com.microservice.demo.model.Passport;

@RestController
@RequestMapping("/passport")
public class PassportRestController {

	private FeignIntegrationClient feignIntegrationClient;
	
	private RestTemplate restTemplate;

	@Autowired
	public PassportRestController(FeignIntegrationClient feignIntegrationClient, RestTemplate restTemplate) {
		this.feignIntegrationClient = feignIntegrationClient;
		this.restTemplate = restTemplate;
	}

	@RequestMapping("/{userId}/passport")
	public Passport passport(@PathVariable String userId) {
		return new Passport(userId, this.feignIntegrationClient.getBookmarksByUserId(userId),
				this.feignIntegrationClient.getContactsByUserId(userId));


	}
	
	@RequestMapping("/message")
	public String message() {
		return "Hello world.";

	}

	@RequestMapping("/{userId}/bookmark")
	public Bookmark bookmark(@PathVariable String userId) {
		//return this.feignIntegrationClient.getBookmarksByUserId(userId);
		return new Bookmark("111","a","b");

	}
	
	@RequestMapping("/{userId}/contacts")
	public Collection<Contact> getContactsByUserId(){		  
		  ParameterizedTypeReference<List<Contact>> responseType = new ParameterizedTypeReference<List<Contact>>(){};
	      ResponseEntity<List<Contact>> exchange = this.restTemplate.exchange(
	                "http://contact-service/{userId}/contacts",
	                HttpMethod.GET, null, responseType, (Object) "pwebb");
	        exchange.getBody().forEach(System.out::println);
	        return exchange.getBody();
	}
}
