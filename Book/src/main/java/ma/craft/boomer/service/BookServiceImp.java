package ma.craft.boomer.service;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.craft.boomer.exception.DataNotFoundException;
import ma.craft.boomer.model.Book;
import ma.craft.boomer.repository.BookRepository;


@Service
public class BookServiceImp implements BookService {
	

	/** The repository. */
	private BookRepository repository;

	/**
	 * Instantiates a new book service imp.
	 *
	 * @param repository the repository
	 */
	@Autowired
	public BookServiceImp(BookRepository repository) {
		this.repository = repository;
	}
	
	/**
	 * Instantiates a new book service imp.
	 */
	public BookServiceImp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see ma.craft.boomer.service.BookService#findAllBooks()
	 */
	public List<Book> findAllBooks() {
		return repository.findAll();
	}
	
	/* (non-Javadoc)
	 * @see ma.craft.boomer.service.BookService#getMessage(int)
	 */
	public Book getMessage(int id) throws DataNotFoundException{
		   //  Message message= messages.get(id);
			Book message= repository.findAll().get(id);
		     if(message == null) {
		    	 throw new DataNotFoundException("message with id ="+id+" not found");	
		     }
		     return message;
		}
	
	/* (non-Javadoc)
	 * @see ma.craft.boomer.service.BookService#Add(ma.craft.boomer.model.Book)
	 */
	public void add(Book book) {
		 repository.save(book);
	}
	
	/* (non-Javadoc)
	 * @see ma.craft.boomer.service.BookService#findById(int)
	 */
	public Book findById(Long id) {
		return repository.findByBookId(id);
	}
	
	/* (non-Javadoc)
	 * @see ma.craft.boomer.service.BookService#isBookExist(ma.craft.boomer.model.Book)
	 */
	public boolean isBookExist(Book book) {
		return repository.findByBookLibelle(book.getBookLibelle()) != null;
	}
	public Book findBookByLibelle(String Libelle) {
		return repository.findByBookLibelle(Libelle);
	}
	
	public Book findBookByAutor(String autor) {
		return repository.findByAutor(autor);
	}
	public void updateBook(Boolean actif, Long userId) {
		 repository.updateBook(actif, userId);
		
	}
}
