package com.example.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springboot.entity.Book;
import com.example.springboot.entity.BookRequest;
import com.example.springboot.entity.SearchCondition;

public interface BookService {
	List<Book> getAllBook();
	void createBook(BookRequest newBook);
	void updateBook(Book newBook);
	void deleteBookById(Long id);
	List<Book> searchBook(SearchCondition searchCondition);
}
