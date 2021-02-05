package com.example.springboot.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.Book;
import com.example.springboot.entity.BookRequest;
import com.example.springboot.entity.SearchCondition;
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBookById(Long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public void updateBook(Book newBook) {
		java.util.Date date = new java.util.Date();
		Book result;
		result = new Book(newBook.getId(), newBook.getName(), newBook.getPublisher(), newBook.getPrice(),
				newBook.getPublish_year(), date, date, newBook.getImage());
		bookRepository.updateBook(result);

	}

	@Override
	public List<Book> searchBook(SearchCondition searchCondition) {
		if (searchCondition.getField() == null || searchCondition.getField().isEmpty()) {
			return bookRepository.findAll();
		}
		if (searchCondition.getField().equals("Book name")) {
			return bookRepository.searchBookByName(searchCondition.getName());
		}
		if (searchCondition.getField().equals("Publisher")) {
			return bookRepository.searchBookByPublisher(searchCondition.getName());
		}
		if (searchCondition.getField().equals("Price")) {
			if (searchCondition.getFrom().isEmpty() && searchCondition.getTo().isEmpty()) {
				return bookRepository.findAll();
			}
			if (searchCondition.getFrom().isEmpty()) {
				return bookRepository.searchBookByPrice(0, Integer.parseInt(searchCondition.getTo()));
			}
			if (searchCondition.getTo().isEmpty()) {
				return bookRepository.searchBookByPrice(Integer.parseInt(searchCondition.getFrom()), 99999);
			}
			return bookRepository.searchBookByPrice(Integer.parseInt(searchCondition.getFrom()),
					Integer.parseInt(searchCondition.getTo()));
		}
		return null;
	}

}
