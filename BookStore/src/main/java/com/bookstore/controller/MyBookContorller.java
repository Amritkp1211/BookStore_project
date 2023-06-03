package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.service.MyBookservice;

@Controller
public class MyBookContorller {
   
	@Autowired
	private MyBookservice myBookservice;
	
	@RequestMapping("/deletemybook/{id}")
	public String delete(@PathVariable("id") int id) {
		   myBookservice.deleteBook(id);
		 return "redirect:/my_books";
	}
}
