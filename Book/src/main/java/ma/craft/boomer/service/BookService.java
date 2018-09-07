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
	public List<Book> findAllMessages();

	/**
	 * Gets the message.
	 *
	 * @param id the id
	 * @return the message
	 * @throws DataNotFoundException the data not found exception
	 */
	public Book getMessage(int id) throws DataNotFoundException;

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
	 */
	public boolean isBookExist(Book book);

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the book
	 */
	public Book findById(int id);
	
	/**
	 * Find book by libelle.
	 *
	 * @param Libelle the libelle
	 * @return the book
	 */
	public Book findBookByLibelle(String Libelle);
	
	/**
	 * Find book by autor.
	 *
	 * @param autor the autor
	 * @return the book
	 */
	public Book findBookByAutor(String autor) ;
}
