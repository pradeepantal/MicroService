package com.microservice.demo.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.microservice.demo.ContactServiceApplication;
import com.microservice.demo.model.Contact;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ContactServiceApplication.class)
public class ContactRepositoryTest {
	
	@Autowired
	private ContactRepository contactRepository;
		
	@Test
	public void shouldGetContactsOfAvailableUser() {
		Collection<Contact> contactList = contactRepository.findByUserId("brunowei");
		assertNotNull(contactList);
		assertTrue(contactList.size() > 0);
	}

	@Test
	public void shouldNotGetContactsOfInvalidUser() {
		Collection<Contact> contactList = contactRepository.findByUserId("InvalidUserId");
		assertNotNull(contactList);
		assertTrue(contactList.size() == 0);
	}

}
