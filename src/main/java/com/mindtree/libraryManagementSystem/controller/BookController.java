package com.mindtree.libraryManagementSystem.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.libraryManagementSystem.dto.BookDto;
import com.mindtree.libraryManagementSystem.model.Book;
import com.mindtree.libraryManagementSystem.model.BookCategory;
import com.mindtree.libraryManagementSystem.repository.BookCategoryRepository;
import com.mindtree.libraryManagementSystem.repository.BookRepository;

@RestController
@RequestMapping("/books1")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	@Autowired
	BookCategoryRepository bookCategoryRepository;
	
//	public Book saveBook(@RequestParam("imageFile") MultipartFile file , @RequestBody Book book) throws IOException {
//		System.out.println("Original Image Byte Size - " + file.getBytes().length);
//		
//		Book b=new Book();
//		return b;
//	}
	@PostMapping
	public Book saveBook(@RequestBody BookDto bookDto) {
		System.out.println("fourign key :"+bookDto.getBookCategoryId());
		BookCategory bookCategory=bookCategoryRepository.getOne(bookDto.getBookCategoryId());
		Book book = new Book(bookDto.getName(),bookDto.getDescription(),bookDto.getUnitsInStock(),bookDto.getCreatedDate(),bookDto.getImage(),bookCategory);
		Book book1=bookRepository.save(book);
		
		return book1;
	}

}
