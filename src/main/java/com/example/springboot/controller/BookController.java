package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.Book;
import com.example.springboot.entity.BookRequest;
import com.example.springboot.service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService bookService;

	@CrossOrigin
	@RequestMapping("/book")
	public List<Book> getAllBook() {
		List<Book> result = bookService.getAllBook();
		return result;
	}

	@CrossOrigin
	@PostMapping(path = "/book", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
	public void createBook(BookRequest newBook) {
		bookService.createBook(newBook);
	}

	@CrossOrigin
	@DeleteMapping(path = "/book/{id}")
	public void index(@PathVariable Long id) {
		bookService.deleteBookById(id);
	}

}
