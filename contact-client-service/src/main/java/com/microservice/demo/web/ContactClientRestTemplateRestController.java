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

import com.microservice.demo.model.Contact;

@RestController
@RequestMapping("/contactRestTemplate")
public class ContactClientRestTemplateRestController {
	
	private RestTemplate restTemplate;

	@Autowired	
	public ContactClientRestTemplateRestController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
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
