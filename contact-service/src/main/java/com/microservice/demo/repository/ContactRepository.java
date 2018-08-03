package com.microservice.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.demo.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	public Collection<Contact> findByUserId(String userId);
}
