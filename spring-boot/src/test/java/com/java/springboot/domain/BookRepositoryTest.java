package com.java.springboot.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class BookRepositoryTest {

	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void testSave() {
		Book book = new Book();
		book.setName("boot-spring-boot");
		book.setIsbn10("0123456789");
		book.setIsbn13("012345678912");
		
		System.out.println("ㅎㅎㅎㅎㅎㅎㅎㅎ"+book+"======================================");
		assertThat(book.isNew()).isTrue();
		bookRepository.save(book);
		
		assertThat(book.isNew()).isTrue();
		
	}
	
	@Test
	public void testFindByNameLike() {
		Book book = new Book();
		book.setName("boot-spring-boot");
		book.setIsbn10("0123456789");
		book.setIsbn13("012345678912");
		
		System.out.println("여기 된건가?"+book);
		List<Book> books = bookRepository.findByNameLike("boot%");
		assertThat(books).isNotEmpty();
		
		books = bookRepository.findByNameLike("boot");
		assertThat(books).isNotEmpty();
	}
}
