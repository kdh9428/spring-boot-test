package com.java.springboot.domain;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor //파라미터가 없는 기본 생성자를 생성해준다.
@Entity//jpa
@Getter
@Setter
@ToString
public class Book extends AbstractPersistable<Long>{

	
	//@GeneratedValue 데이터베이스에서 auto-increment시켜준다.
	
	private String name;
	private String isbn13;
	private String isbn10;
	
}
