package ma.craft.boomer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.craft.boomer.exception.DataNotFoundException;
import ma.craft.boomer.model.Book;
import ma.craft.boomer.service.BookService;



@RestController
@CrossOrigin(origins="http://localhost:4200" , allowedHeaders="*")
public class BookController {
	
	/** The Book service. */
	@Autowired
	private BookService bookService;

	/**
	 * All Books
	 * 
	 * @return the response entity en affichant tout les books
	 */
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> listAllStudents() {
		List<Book> messages = bookService.findAllMessages();
		if (messages.isEmpty()) {
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Book>>(messages, HttpStatus.OK);
	}
	/**
	 * Get Book
	 * @param id 
	 * @return the book
	 * @throws DataNotFoundException the data not found exception
	 * retourner juste un book en presisant son ID 
	 */
	@RequestMapping(value="/book/{id}" , method=RequestMethod.GET )
	public Book getBook(@PathVariable("id") int id) throws DataNotFoundException
	{
		return bookService.findById(id);
	}
	/**
	 * Add Book.
	 *
	 * @param book the book
	 * @return the response entity
	 */
	@PostMapping(value = "/book")
	public void add(@RequestBody Book book) {
		bookService.add(book);
	}


	
	/**
	 * get Book by libelle
	 */
	public Book getBookByLibelle(String libelle) {
		
		if(bookService.findBookByLibelle(libelle) != null) {
			return bookService.findBookByLibelle(libelle);
		}
		return null;
	}
	/**
	 * get Book by AUtor
	 */
	public Book getBookByAutor(String autor) {
		
		if(bookService.findBookByAutor(autor) != null) {
			return bookService.findBookByAutor(autor);
		}
		return null;
	}
	
	
}
