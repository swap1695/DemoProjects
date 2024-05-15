package com.example.bookshelf.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bookshelf.model.BookDetails;
import com.example.bookshelf.repository.BookShelfRepository;

import exception.ResourceNotFoundException;

@Service
public class BookShelfService {
	
	@Autowired
	private BookShelfRepository bookShelfRepository;

	public List<BookDetails> getAllBooks() {
		
		List<BookDetails> books = new ArrayList<BookDetails>();  
		bookShelfRepository.findAll().forEach(books1 -> books.add(books1));  
		return books;  
	}

	public BookDetails getBookById(int bookId) {
		
		 return bookShelfRepository.findById(bookId).get();
	}


	public void addBook(BookDetails book) {
		
		  bookShelfRepository.save(book);
		
	}

	public void deleteBook(int bookId) {
		bookShelfRepository.deleteById(bookId);;
		
	}

	public ResponseEntity<BookDetails> update(int id, BookDetails book) {
		BookDetails updateBook = bookShelfRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

		updateBook.setBookId(book.getBookId());
		updateBook.setBookName(book.getBookName());
		updateBook.setAuthorName(book.getAuthorName());

        bookShelfRepository.save(updateBook);
		return ResponseEntity.ok(updateBook);
		
	}

}
