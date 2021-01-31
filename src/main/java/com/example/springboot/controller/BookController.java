package com.example.springboot.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	@Autowired
	BookRepository bookRepository;

	@CrossOrigin
	@RequestMapping("/book")
	public List<Book> getAllBook() {
		List<Book> result = bookRepository.findAll();
		return result;
	}
	
	@CrossOrigin
	@PostMapping(path = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book index(@RequestBody Book newBook) {
		java.util.Date date=new java.util.Date();  
		newBook.setCreated_datetime(date);
		newBook.setUpdated_datetime(date);
		Book result = bookRepository.save(newBook);
		return result;
	}
	
	@CrossOrigin
	@DeleteMapping(path = "/book/{id}")
	public void index(@PathVariable Long id) {
		bookRepository.deleteById(id);
	}
}
