package com.mindtree.libraryManagementSystem.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="book")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Book implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="unitsInStock")
	private int unitsInStock;
	
	@Column(name="createdDate")
	private Date createdDate;
	//image bytes can have larger lengths so we specify a value
	//which is more than the default length for image column
	@Column(name="image_book", length=1000)
	private byte[] image;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="bookCategory_id")
	BookCategory bookCategory;

	public Book(String name, String description, int unitsInStock, Date createdDate, byte[] image,
			BookCategory bookCategory) {
		super();
		this.name = name;
		this.description = description;
		this.unitsInStock = unitsInStock;
		this.createdDate = createdDate;
		this.image = image;
		this.bookCategory = bookCategory;
	}

	public Book(String name, String description, int unitsInStock, byte[] image, BookCategory bookCategory) {
		super();
		this.name = name;
		this.description = description;
		this.unitsInStock = unitsInStock;
		this.image = image;
		this.bookCategory = bookCategory;
	}

	public Book(String name, String description, int unitsInStock, BookCategory bookCategory) {
		super();
		this.name = name;
		this.description = description;
		this.unitsInStock = unitsInStock;
		this.bookCategory = bookCategory;
	}

	public Book() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
