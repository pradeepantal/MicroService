package com.microservice.demo.model;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.microservice.demo.model.Bookmark;
import com.microservice.demo.repository.BookmarkRepository;

@Component
public class InitData {

    @Bean
    CommandLineRunner init(@Value("${bookmark.mask}") String bookmarkMask, BookmarkRepository br) {
        return args ->{
        	 Arrays.asList("jlong,rwinch,dsyer,pwebb,sgibb,brunowei".split(",")).forEach(userId -> {
                 String href = String.format("http://%s-link.com", userId);
                 String descriptionForBookmark = this.descriptionForBookmark(bookmarkMask, userId, href);
                 br.save(new Bookmark(href, userId, descriptionForBookmark));
             }); 
        	 br.findAll().forEach(System.out::println);
        };                                    
    }
    
    private String descriptionForBookmark(String mask, String userId, String href) {
        return mask.replaceFirst("_L_", href)
                .replaceFirst("_U_", userId);
    }

}
