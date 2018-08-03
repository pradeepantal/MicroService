package com.microservice.demo.web;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.demo.model.Contact;
import com.microservice.demo.service.ClientLeadService;

@RestController
public class ClientLeadsConroller {

	@Inject
	private ClientLeadService service;
	
	@RequestMapping("/{emailId}/clientleads")
	public Collection<Contact> getClientLeadsByEmailAddress(@PathVariable String emailId){
		return service.findClientLeadsByEmail(emailId);
	}	
	
	
}
