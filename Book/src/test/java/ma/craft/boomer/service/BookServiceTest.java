package ma.craft.boomer.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ma.craft.boomer.model.Book;
import ma.craft.boomer.model.Book.BookBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {
	

	@Test
	public void addShouldBuildBook() {
		Book book = BookBuilder.create().libelle("test")
				.autor("dd")
				.prix(10)
				.description("dd")
				.quantite(100)
				.build();
		assertNotNull(book);
	}
}
