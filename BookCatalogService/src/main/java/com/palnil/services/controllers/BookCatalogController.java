package com.palnil.services.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.palnil.services.beans.Book;

@RestController
public class BookCatalogController {
	
	private List<Book> books = null;

	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public Book getBook(@RequestParam(value="id", defaultValue="0") int id) {
		
		System.out.println("================= BookCatalogController.getBook() =========================");
		createBooks();
		Book book = fetchBook(id);
		
		// Done
		return book;
		
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public List<Book> getBooks() {
		
		System.out.println("================= BookCatalogController.getBooks() =========================");
		return createBooks();
		
	}
	
	
	
	@RequestMapping(value = "/createBook", method = RequestMethod.POST)
	public Book createBook(@Valid @RequestBody Book book) {
		
		System.out.println("================= BookCatalogController.createBook =========================");
		System.out.println("Create Book:\n" + book);
		
		
		// Done
		Book newBook = new Book();
		newBook.setId(book.getId());
		newBook.setTitle(book.getTitle());
		return newBook;	
	}
	
	
	@RequestMapping(value = "/updateBook", method = RequestMethod.PUT)
	public Book updateBook(@Valid @RequestBody Book book) {
		
		System.out.println("================= BookCatalogController.updateBook =========================");
		System.out.println("Update Book:\n" + book);
		
		
		// Done
		Book newBook = new Book();
		newBook.setId(book.getId());
		newBook.setTitle(book.getTitle());
		return newBook;	
	}
	
	
	@RequestMapping(value = "/deleteBook", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteBook(@RequestParam(value="id") int id) {
		
		System.out.println("================= BookCatalogController.deleteBook =========================");
		System.out.println("Delete Book: " + id);
		return ResponseEntity.ok().build();
		// return ResponseEntity.noContent().build();
	}
	
	
	
	private List<Book> createBooks() {
		if (books == null) {
			books = new ArrayList<Book>();
			for (int i = 0; i < 3; i++) {
				Book book = new Book();
				book.setId(i);
				book.setTitle("Book " + i);
				books.add(book);
			}
		}
		return books;
	}
	
	private Book fetchBook(int id) {
		for (Book book : books) {
			if (book.getId() == id) {
				return book;
			}
		}
		return null;
	}
    

    
    
}