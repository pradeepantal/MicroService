package com.microservice.demo.feign.integration;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservice.demo.feign.BookmarkFeignClient;
import com.microservice.demo.model.Bookmark;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class FeignIntegrationClient {

	private BookmarkFeignClient bookmarkFeignClient;
	
	@Autowired
	public FeignIntegrationClient(BookmarkFeignClient bookmarkFeignClient) {
		this.bookmarkFeignClient = bookmarkFeignClient;
	}
	
	@HystrixCommand(fallbackMethod="getBookmarksFallback")
	public Collection<Bookmark> getBookmarksByUserId(String userId){
		return this.bookmarkFeignClient.getBookmarks(userId);
	}
	
    public Collection<Bookmark> getBookmarksFallback(String userId) {
        System.out.println("No service available at the moment, please try later.");
        return Arrays.asList();
    }

}
