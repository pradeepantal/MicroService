package com.microservice.demo.feign.integration;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservice.demo.feign.BookmarkFeignClient;
import com.microservice.demo.feign.ContactFeignClient;
import com.microservice.demo.model.Bookmark;
import com.microservice.demo.model.Contact;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class FeignIntegrationClient {

	private BookmarkFeignClient bookmarkFeignClient;
	
	private ContactFeignClient contactFeignClient;
	
	@Autowired
	public FeignIntegrationClient(BookmarkFeignClient bookmarkFeignClient, ContactFeignClient contactFeignClient) {
		this.bookmarkFeignClient = bookmarkFeignClient;
		this.contactFeignClient = contactFeignClient;
	}
	
	@HystrixCommand(fallbackMethod="getBookmarksFallback")
	public Collection<Bookmark> getBookmarksByUserId(String userId){
		return this.bookmarkFeignClient.getBookmarks(userId);
	}
	
    public Collection<Bookmark> getBookmarksFallback(String userId) {
        System.out.println("No bookmark service available at the moment, please try later.");
        return Arrays.asList();
    }
    
    @HystrixCommand(fallbackMethod="getContactsFallback")
	public Collection<Contact> getContactsByUserId(String userId){
		return this.contactFeignClient.getContacts(userId);
	}
    
    public Collection<Contact> getContactsFallback(String userId) {
        System.out.println("No contact service available at the moment, please try later.");
        return Arrays.asList();
    }

}
