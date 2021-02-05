package com.example.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.springboot.entity.Book;
import com.example.springboot.entity.SearchCondition;

@Mapper
public interface BookMapper {
	List<Book> findAll();

	void insertBook(@Param("book") Book book);

	void updateBook(@Param("book") Book book);

	void deleteById(Long id);

	List<Book> searchBookByName(@Param("name") String name);
	List<Book> searchBookByPublisher(@Param("name") String name);
	List<Book> searchBookByPrice(@Param("from") int from,@Param("to") int to);
}