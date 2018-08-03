package com.microservice.demo.web;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.demo.model.Contact;
import com.microservice.demo.repository.ContactRepository;

@RefreshScope
@RestController
public class ContactRestController {
	
	//@Value("${message}")
	private String message;
	
	private ContactRepository contactRepository;
	
	@Autowired
	public ContactRestController(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}
	
	@RequestMapping("/{userId}/contacts")
	public Collection<Contact> getContactsByUserId(@PathVariable String userId){
		//return getHardCodedContacts();
		return this.contactRepository.findByUserId(userId);
	}
	
	private Collection<Contact> getHardCodedContacts() {
		
		Collection<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact("A1", "FName", "LName", "dummy@email.com"));
		
		return contacts;
	}

	@RequestMapping("/message")
	public String getMessage(){
		return this.message;
	}
	
}
