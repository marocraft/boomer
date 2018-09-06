package ma.craft.boomer.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.craft.boomer.exception.DataNotFoundException;
import ma.craft.boomer.model.Book;
import ma.craft.boomer.service.BookService;


@RestController
public class BookController {
	
	@Autowired
	private BookService BookService;

	//404 not found
	@GetMapping(value="/message")
	public String HelloWord() {
		return "hello soukaina !!! ";
	}
	
	//400 bad request
	@GetMapping(value="/message/{id}")
	public int Method2(@PathVariable("id") int id)
	{
		try {
			BookService.getMessage(id);
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	/******************************
	 * All Books
	 * 
	 *********************************/
	@RequestMapping(value = "/AllBooks", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> listAllStudents() {
		List<Book> messages = BookService.findAllMessages();
		if (messages.isEmpty()) {
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Book>>(messages, HttpStatus.OK);
	}

	/******************************
	 * Get Book
	 * 
	 *********************************/
	@RequestMapping(value="/Book/{id}" , method=RequestMethod.GET )
	public Book getMessage(@PathVariable("id") int id) throws DataNotFoundException
	{
		return BookService.findById(id);
		 //return messageservice.getMessage(id);
		// return new ResponseEntity<>("success " , HttpStatus.OK );
	}
	
	
	/**
	 * Add Book
	 * @param book
	 * @return
	 */
	@RequestMapping(value = "/Book", method = RequestMethod.POST)
	public ResponseEntity<Book> Add(@RequestBody Book book) {

		if (BookService.isBookExist(book)) {
			return new ResponseEntity<Book>(HttpStatus.CONFLICT);
		}

		BookService.Add(book);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	
	/******************************
	 * Delete Book
	 *********************************/
	@RequestMapping(value = "/Book/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Book> deleteClasss(@PathVariable("id") int id) {

		Book book = BookService.findById(id);
		if (book == null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}

		BookService.deleteBookById(id);
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping(value="/exception")
	public String exception() throws FileNotFoundException{
		throw new FileNotFoundException("ngfhfhgfgh");
	}
}
