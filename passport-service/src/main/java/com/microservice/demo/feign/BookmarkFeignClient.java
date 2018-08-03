package com.microservice.demo.feign;

import java.util.Collection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.microservice.demo.model.Bookmark;

@FeignClient("bookmark-service")
public interface BookmarkFeignClient {
	@RequestMapping(method = RequestMethod.GET, value = "/{userId}/bookmarks")
	public Collection<Bookmark> getBookmarks(@PathVariable("userId") String userId);
}
