package ma.craft.boomer.service;

import java.util.List;

import ma.craft.boomer.exception.DataNotFoundException;
import ma.craft.boomer.model.Book;

public interface BookService {
	public List<Book> findAllMessages();

	public Book getMessage(int id) throws DataNotFoundException;

	public void Add(Book message);

	void deleteBookById(int id);

	public boolean isBookExist(Book book);

	public Book findById(int id);
}
