package ma.craft.boomer.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ma.craft.boomer.model.Book;
import ma.craft.boomer.repository.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {
	@Autowired private BookService bookService;
	@Autowired private BookRepository bookRepository;

	@Test
	public void addShouldSaveBook() {
		//Book book = new Book("test","dd","dd",10,100.10,10L);
		
		//bookService.add(book);
		
		//Book dbBook = bookRepository.findAll().get(0);
		
		//assertEquals(book, dbBook);
	}
}
