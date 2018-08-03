package com.microservice.demo.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.demo.feign.integration.FeignIntegrationClient;
import com.microservice.demo.model.Bookmark;

@RestController
@RequestMapping("/bookmarkFeignClient")
public class BookmarkClientFeignClientRestController {
	
	private FeignIntegrationClient feignIntegrationClient;
	
	@Autowired
	public BookmarkClientFeignClientRestController(FeignIntegrationClient feignIntegrationClient) {
		this.feignIntegrationClient = feignIntegrationClient;
	}
	
	@RequestMapping("/{userId}/bookmarks")
	public Collection<Bookmark> getBookmarksByUserId(@PathVariable String userId){
		return this.feignIntegrationClient.getBookmarksByUserId(userId);
	}	

}
