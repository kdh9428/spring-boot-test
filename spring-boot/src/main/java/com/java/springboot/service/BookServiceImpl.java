package com.java.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.springboot.domain.Book;
import com.java.springboot.domain.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	private final BookRepository bookRepository;
	
	@Value("아이우에오")
	public String testt;
	
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Optional<Book> findById(Long id) {
		System.out.println("================test================" +testt);
		return bookRepository.findById(id);
	}

}
