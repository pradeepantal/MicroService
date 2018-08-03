package com.microservice.demo.service;

import java.util.Collection;

import com.microservice.demo.model.Contact;

public interface ClientLeadService {
	
	public Collection<Contact> findClientLeadsByEmail(String emailId) ;

}
