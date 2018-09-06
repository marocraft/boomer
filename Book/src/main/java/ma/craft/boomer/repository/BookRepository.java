package ma.craft.boomer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.craft.boomer.model.Book;


public interface BookRepository extends JpaRepository<Book, Integer> {
	public Book findByBookId(int id);
	public Book findByBookLibelle(String name);

}
