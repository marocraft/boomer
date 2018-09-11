package ma.craft.boomer.service;

import java.util.List;

import ma.craft.boomer.exception.DataNotFoundException;
import ma.craft.boomer.model.Book;

public interface BookService {
	
	/**
	 * Find all messages.
	 *
	 * @return the list
	 */
	public List<Book> findAllBooks();

	/**
	 * Adds the book.
	 *
	 * @param book the book
	 */
	public void add(Book book);

	/**
	 * Checks if is book exist.
	 *
	 * @param book the book
	 * @return true, if is book exist
	 * @throws DataNotFoundException 
	 */
	public boolean isBookExist(Book book) throws DataNotFoundException;

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the book
	 */
	public Book findById(Long id);
	
	/**
	 * Find book by libelle.
	 *
	 * @param Libelle the libelle
	 * @return the book
	 */
	public void updateBook(Boolean actif, Long userId);	
	public Book findBookByLibelle(String libelle) throws DataNotFoundException;
	
	/**
	 * Find book by autor.
	 *
	 * @param autor the autor
	 * @return the book
	 */
	public Book findBookByAutor(String autor) ;
}
