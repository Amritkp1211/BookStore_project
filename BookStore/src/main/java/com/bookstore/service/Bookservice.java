package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entities.Book;
import com.bookstore.repository.Bookrepository;

@Service
public class Bookservice {
     
	@Autowired
	private Bookrepository brepoBookrepository;
	 
	public void save(Book b) {
		 brepoBookrepository.save(b);
	}
	public List<Book> allBooks(){
		return brepoBookrepository.findAll();
	}
	public Book getBookById(int id) {
		return brepoBookrepository.findById(id).get();	
	}
	public void deleteBookByID(int id) {
		brepoBookrepository.deleteById(id);
	}
}
