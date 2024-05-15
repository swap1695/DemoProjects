package com.example.bookshelf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookshelf.model.BookDetails;
import com.example.bookshelf.service.BookShelfService;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class BookShelfController {
	
	@Autowired
	private BookShelfService bookShelfService;
	
	@GetMapping("/getAllBooks")
	public List<BookDetails> getAllBooks(){
		return bookShelfService.getAllBooks();		
	}
	
	@GetMapping("/getAllBooks/{id}")
	public BookDetails getBook(@PathVariable int bookId){
		return bookShelfService.getBookById(bookId);		
	}
	
	@PostMapping("/addBook")
	public String addBook(@RequestBody BookDetails book) {
		bookShelfService.addBook(book);
		return "Book is added Successfully with bookId: "+book.getBookId();
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable int bookId) {
		bookShelfService.deleteBook(bookId);
		return "Book with bookId: "+bookId+" is deleted";
	}
	
	@PutMapping("/updateBook/{id}")
	public BookDetails putMethodName(@PathVariable int id, @RequestBody BookDetails book) {
		bookShelfService.update(id,book);		
		return book;
	}
	

}
		