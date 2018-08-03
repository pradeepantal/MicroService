package com.microservice.demo.gateway;

import java.util.Collection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.microservice.demo.model.Contact;
@FeignClient("contact-service")
public interface ContactServiceGateway {

	@RequestMapping(method = RequestMethod.GET, value = "/{userId}/contacts")
	public Collection<Contact> findContactsByUserId(@PathVariable("userId") String userId);

}
