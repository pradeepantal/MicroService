package com.microservice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableFeignClients
@EnableZuulProxy
public class BookmarkClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmarkClientServiceApplication.class, args);
	}
}
