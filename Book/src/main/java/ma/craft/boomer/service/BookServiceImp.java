package ma.craft.boomer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.craft.boomer.exception.DataNotFoundException;
import ma.craft.boomer.model.Book;
import ma.craft.boomer.repository.BookRepository;

@Service
public class BookServiceImp implements BookService{
	
	
//	private Map<Integer,Message> messages = DatabaseClass.getMessages();
    
	
	
	/*public Map<Integer, Message> getMessages() {
		return messages;
	}


	public void setMessages(Map<Integer, Message> messages) {
		this.messages = messages;
	}

*/
	private BookRepository repository;

	@Autowired
	public BookServiceImp(BookRepository repository) {
		this.repository = repository;
	}
	public BookServiceImp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Book> findAllMessages() {
		return repository.findAll();
	}
	public Book getMessage(int id) throws DataNotFoundException{
		   //  Message message= messages.get(id);
			Book message= repository.findAll().get(id);
		     if(message == null) {
		    	 throw new DataNotFoundException("message with id ="+id+" not found");	
		     }

		  //   if(id instanceof Integer	)
		     return message;
		}
	public void Add(Book message) {
		 repository.save(message);
	}
	public Book findById(int id) {
		return repository.findByBookId(id);
	}
	public void deleteBookById(int id) {

		repository.deleteById(id);
	}
	public boolean isBookExist(Book book) {
		return repository.findByBookLibelle(book.getBookLibelle()) != null;
	}
	
}
