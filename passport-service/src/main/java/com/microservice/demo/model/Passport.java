package com.microservice.demo.model;

import java.util.Collection;

public class Passport {

	private String userId;
	private Collection<Bookmark> bookmarks;
	private Collection<Contact> contacts;
	
	public Passport(){
		
	}

	public Passport(String userId, Collection<Bookmark> bookmarks, Collection<Contact> contacts) {
		this.userId = userId;
		this.bookmarks = bookmarks;
		this.contacts = contacts;
	}
	
	@Override
	public String toString() {
		return "Passport{" + "userId='" + userId + '\'' + ", bookmarks=" + bookmarks + ", contacts=" + contacts + '}';
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Collection<Bookmark> getBookmarks() {
		return bookmarks;
	}

	public void setBookmarks(Collection<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}

	public Collection<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Collection<Contact> contacts) {
		this.contacts = contacts;
	}

	

}
