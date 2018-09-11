package ma.craft.boomer.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.craft.boomer.exception.DataNotFoundException;
import ma.craft.boomer.model.Book;


@Repository
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
	public Book findByBookId(Long id);
	
	@Transactional
	@Modifying
	@Query(nativeQuery=true,value="update book b set b.actif = :actif  where b.book_id= :book_id")
	void updateBook(@Param("actif") boolean actif,@Param("book_id") long bookId);	
	/**
	 * Find by book libelle.
	 *
	 * @param name the name
	 * @return the book
	 */
	public Book findByBookLibelle(String name) throws DataNotFoundException;

	/**
	 * Find by autor.
	 *
	 * @param autor the autor
	 * @return the book
	 */
	public Book findByAutor(String autor);

}
