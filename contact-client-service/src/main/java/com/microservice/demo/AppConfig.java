package com.microservice.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microservice.demo.repository.ClientLeadRepository;
import com.microservice.demo.repository.ClientLeadRepositoryImpl;
import com.microservice.demo.service.ClientLeadService;
import com.microservice.demo.service.ClientLeadServiceImpl;

@Configuration
public class AppConfig {
   
	@Bean
    public ClientLeadRepository clientLeadRepository() {
        return new ClientLeadRepositoryImpl();
    }
    
	@Bean
    public ClientLeadService clientLeadService() {
        return new ClientLeadServiceImpl();
    }
    
}
     