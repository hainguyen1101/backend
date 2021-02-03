package com.example.springboot.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.Book;
import com.example.springboot.entity.BookRequest;
import com.example.springboot.mapper.BookMapper;
import com.example.springboot.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper bookRepository;

	@Override
	public List<Book> getAllBook() {
		return bookRepository.findAll();
	}

	@Override
	public void createBook(BookRequest newBook) {
		java.util.Date date = new java.util.Date();
		Book result;
		try {
			result = new Book(null, newBook.getName(), newBook.getPublisher(), newBook.getPrice(),
					newBook.getPublish_year(), date, date, newBook.getImage().getBytes());
			bookRepository.insertBook(result);
//			return resultResponse;
		} catch (IOException e) {
			e.printStackTrace();
		}
//		return null;
	}

	@Override
	public void deleteBookById(Long id) {
		bookRepository.deleteById(id);
	}

}
