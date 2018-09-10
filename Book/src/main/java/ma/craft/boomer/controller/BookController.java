package ma.craft.boomer.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	private static final Logger logger = Logger.getLogger(BookController.class);

	/** The Book service. */
	@Autowired
	private BookService bookService;

	/**
	 * All Books
	 * 
	 * @return the response entity shown all books
	 */
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> listAllStudents() {
		List<Book> messages = bookService.findAllBooks();
		if (messages.isEmpty()) {
			logger.error("Controller :not enough books");
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		}
		logger.info("Controller : Show all Books");
		return new ResponseEntity<List<Book>>(messages, HttpStatus.OK);
	}
	/**
	 * Get Book
	 * @param id 
	 * @return the book
	 * @throws DataNotFoundException the data not found exception
	 * return just a book with an ID
	 */
	@GetMapping(value="/book/{id}"  )
	public Book getBook(@PathVariable("id") Long id) throws DataNotFoundException
	{ 
		if(bookService.isBookExist(bookService.findById(id))) {
			logger.error("Controller : book not found");
		}
		logger.info("Controller : getting a book");
		return bookService.findById(id);
	}
	/**
	 * Add Book.
	 *
	 * @param book the book
	 * @return the response entity for add a book
	 */
	@PostMapping(value = "/book")
	public void add(@RequestBody Book book) {
		// when i add a book , in the first time , it is on
		book.setActif(true);
		
		bookService.add(book);
		logger.info("Controller : adding a book");
	}
	
	@GetMapping(value="/bloquer/{id}" )
	public String updateActif(@PathVariable("id") Long id) 
	{    
		logger.info("Controller : Blooking a book");

		 bookService.updateBook(false,id);
		 return "ok";
	}

	/**
	 * get Book by libelle
	 */
	public Book getBookByLibelle(String libelle) {
		
		if(bookService.findBookByLibelle(libelle) != null) {
			logger.info("Controller : finding a book with the libelle  : "+libelle);
			return bookService.findBookByLibelle(libelle);
		}
		return null;
	}
	/**
	 * get Book by AUtor
	 */
	public Book getBookByAutor(String autor) {
		
		if(bookService.findBookByAutor(autor) != null) {
			logger.info("Controller : finding a book with the autor is : "+autor);
			return bookService.findBookByAutor(autor);
		}
		return null;
	}
	
	
}
