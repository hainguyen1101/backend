package com.example.springboot.entity;

import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

public class BookRequest {
	private Long id;
	private String name;
	private String publisher;
	private String price;
	private String publish_year;
	private Date created_datetime;
	private Date updated_datetime;
	private MultipartFile image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPublish_year() {
		return publish_year;
	}

	public void setPublish_year(String publish_year) {
		this.publish_year = publish_year;
	}

	public Date getCreated_datetime() {
		return created_datetime;
	}

	public void setCreated_datetime(Date created_datetime) {
		this.created_datetime = created_datetime;
	}

	public Date getUpdated_datetime() {
		return updated_datetime;
	}

	public void setUpdated_datetime(Date updated_datetime) {
		this.updated_datetime = updated_datetime;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

}
