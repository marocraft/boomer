package ma.craft.boomer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.craft.boomer.model.Book;


// TODO: Auto-generated Javadoc
/**
 * The Interface BookRepository.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
	
	/**
	 * Find by book id.
	 *
	 * @param id the id
	 * @return the book
	 */
	public Book findByBookId(int id);
	
	/**
	 * Find by book libelle.
	 *
	 * @param name the name
	 * @return the book
	 */
	public Book findByBookLibelle(String name);

	/**
	 * Find by autor.
	 *
	 * @param autor the autor
	 * @return the book
	 */
	public Book findByAutor(String autor);

}
