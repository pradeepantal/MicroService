package com.microservice.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.demo.model.Bookmark;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long>{

	public Collection<Bookmark> findByUserId(String userId);
}
