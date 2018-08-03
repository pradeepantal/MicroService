package com.microservice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class ContactServiceApplication {

    public static void main(String args[]) throws Throwable {
        SpringApplication.run(ContactServiceApplication.class, args);
    }
}