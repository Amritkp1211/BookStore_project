package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entities.MyBook;
import com.bookstore.repository.MyBookrepository;

@Service
public class MyBookservice {
     
	@Autowired
	private MyBookrepository myBookrepository;
	
	public void mybooks(MyBook  myBook) {
		myBookrepository.save(myBook);
	}
	
	public List<MyBook> getAllmybook(){
	  return myBookrepository.findAll();
		}
	
	public void deleteBook(int id) {
		myBookrepository.deleteById(id);
	}
}
