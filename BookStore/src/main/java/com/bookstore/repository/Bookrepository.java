package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.entities.Book;

@Repository
public interface Bookrepository extends JpaRepository<Book, Integer> {

}
