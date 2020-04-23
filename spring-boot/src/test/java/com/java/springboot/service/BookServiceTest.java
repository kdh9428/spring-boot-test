package com.java.springboot.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ExtendWith(SpringExtension.class)
public class BookServiceTest {

	@Autowired
	BookService bookService;
	
	@Test
	public void testFindById() {
		
		Long id = 1L;
		bookService.findById(id)
		.orElseThrow(() -> new RuntimeException("Not found"));
	}
	
}
