package com.mindtree.libraryManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mindtree.libraryManagementSystem.model.BookCategory;

@CrossOrigin(origins="http://localhost:4200")
@RepositoryRestResource(collectionResourceRel="bookCategories", path="bookCategories")
public interface BookCategoryRepository extends JpaRepository<BookCategory,Long> {

}
