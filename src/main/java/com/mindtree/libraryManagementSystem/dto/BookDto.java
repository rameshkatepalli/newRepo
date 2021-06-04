package com.mindtree.libraryManagementSystem.dto;

import java.util.Date;

public class BookDto {
	
	private long id;
	
	//@Column(name="name")
	private String name;
	
	//@Column(name="description")
	private String description;
	
	//@Column(name="unitsInStock")
	private int unitsInStock;
	
	private Date createdDate;
	
	//image bytes can have larger lengths so we specify a value
	//which is more than the default length for image column
	//@Column(name="image_book", length=1000)
	private byte[] image;
	
	private long bookCategoryId;
	
	

	public BookDto(long id, String name, String description, int unitsInStock, Date createdDate, byte[] image,
			long bookCategoryId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.unitsInStock = unitsInStock;
		this.createdDate = createdDate;
		this.image = image;
		this.bookCategoryId = bookCategoryId;
	}

	public BookDto(long id, String name, String description, int unitsInStock, byte[] image, long bookCategoryId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.unitsInStock = unitsInStock;
		this.image = image;
		this.bookCategoryId = bookCategoryId;
	}

	public BookDto(String name, String description, int unitsInStock, byte[] image, long bookCategoryId) {
		super();
		this.name = name;
		this.description = description;
		this.unitsInStock = unitsInStock;
		this.image = image;
		this.bookCategoryId = bookCategoryId;
	}

	public BookDto() {
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public long getBookCategoryId() {
		return bookCategoryId;
	}

	public void setBookCategoryId(long bookCategoryId) {
		this.bookCategoryId = bookCategoryId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
