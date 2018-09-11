package ma.craft.boomer.demo.entities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InterReposetory extends JpaRepository<Book, Long> {
	

}
