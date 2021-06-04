package com.mindtree.libraryManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.libraryManagementSystem.model.Book;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel="books", path="books")
public interface BookRepository extends JpaRepository<Book,Long> {

	List<Book> findByBookCategoryId(@RequestParam("id") long id);
}
