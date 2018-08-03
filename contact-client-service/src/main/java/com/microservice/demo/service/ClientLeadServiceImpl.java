package com.microservice.demo.service;

import java.util.Collection;

import javax.inject.Inject;

import com.microservice.demo.gateway.ContactServiceGateway;
import com.microservice.demo.model.Contact;
import com.microservice.demo.repository.ClientLeadRepository;

public class ClientLeadServiceImpl implements ClientLeadService {

	@Inject
	private ClientLeadRepository clientLeadRepository;
	
	@Inject
	private ContactServiceGateway gateway;
	
	@Override
	public Collection<Contact> findClientLeadsByEmail(String emailId) {
		
		String userId = getUserIdOfAssociatedToThisEmail(emailId);
		
		return gateway.findContactsByUserId(userId);
	}

	private String getUserIdOfAssociatedToThisEmail(String emailId) {
		return clientLeadRepository.getUserIdByEmail(emailId);
	}

}
