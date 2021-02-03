package com.example.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springboot.entity.Book;
import com.example.springboot.entity.BookRequest;

public interface BookService {
	List<Book> getAllBook();
	void createBook(BookRequest newBook);
	void deleteBookById(Long id);
}
