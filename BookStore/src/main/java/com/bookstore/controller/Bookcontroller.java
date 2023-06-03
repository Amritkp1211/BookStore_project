package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.entities.Book;
import com.bookstore.entities.MyBook;
import com.bookstore.service.Bookservice;
import com.bookstore.service.MyBookservice;

@Controller
public class Bookcontroller {
	
    @Autowired
	private Bookservice bookservice;
    
    @Autowired
    private MyBookservice myBookservice;
    
	@GetMapping("/home")
	public String Home() {
		return "home";
	}
	
	@GetMapping("/available_books")
	public ModelAndView available() {
		List<Book> list = bookservice.allBooks();
		/*
		 * ModelAndView mv =new ModelAndView();
		 *  mv.setViewName("available_books");
		 * mv.addObject("book",list); return mv;
		 */
		return new ModelAndView("allbooks","book",list);
	}
	
	@GetMapping("/my_books")
	public String mybooks(Model model) {
		 List<MyBook> list1 = myBookservice.getAllmybook();
		 model.addAttribute("book", list1);
		return "mybooks";
	}
	@GetMapping("/register_book")
	public String newbook() {
		return "register";
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book book ) {
	   bookservice.save(book);
		return "redirect:/available_books";
	}
	
	@RequestMapping("/mybooks/{id}")
	public String getbookbyid(@PathVariable("id") int id) {
		Book book=bookservice.getBookById(id);
		MyBook mb=new MyBook(book.getId(),book.getName(), book.getAuthor(), book.getPrice());
		myBookservice.mybooks(mb);
      	return "redirect:/my_books";
	}
	
	@RequestMapping("/edit/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book book = bookservice.getBookById(id);
		model.addAttribute("book", book);
		return "edit";
	}
	@RequestMapping("/deletebook/{id}")
	public String deleteBookbyid(@PathVariable("id") int id) {
		bookservice.deleteBookByID(id);
		return "redirect:/available_books";
	}
	
}
