package com.microservice.demo.repository;

public class ClientLeadRepositoryImpl implements ClientLeadRepository {

	@Override
	public String getUserIdByEmail(String emailId) {
		
		if(emailId.equals("dave@email.com"))
			return "brunowei";
		
		return "InvalidUserId";
	}

}
