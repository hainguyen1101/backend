package com.example.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "book")
public class Book implements Serializable {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String publisher;
	private String price;
	private String publish_year;
	private Date created_datetime;
	private Date updated_datetime;
	private byte[] image;

	public Book() {
		super();
	}

	public Book(Long id, String name, String publisher, String price, String publish_year, Date created_datetime,
			Date updated_datetime, byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.publisher = publisher;
		this.price = price;
		this.publish_year = publish_year;
		this.created_datetime = created_datetime;
		this.updated_datetime = updated_datetime;
		this.image = image;
	}

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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
