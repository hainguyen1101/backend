package com.example.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.springboot.entity.Book;

@Mapper
public interface BookMapper  {
	List<Book> findAll();
	void insertBook(@Param("book") Book book);
	void deleteById(Long id);
}