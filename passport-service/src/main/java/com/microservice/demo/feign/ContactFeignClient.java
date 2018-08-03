package com.microservice.demo.feign;

import java.util.Collection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.microservice.demo.model.Contact;

@FeignClient("contact-service")
public interface ContactFeignClient {
	@RequestMapping(method = RequestMethod.GET, value = "/{userId}/contacts")
	public Collection<Contact> getContacts(@PathVariable("userId") String userId);
}
