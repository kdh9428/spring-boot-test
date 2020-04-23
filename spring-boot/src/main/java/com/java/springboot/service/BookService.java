package com.java.springboot.service;

import java.util.Optional;

import com.java.springboot.domain.Book;

public interface BookService {
	
	Optional<Book> findById(Long id);
}
