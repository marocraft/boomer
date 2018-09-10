package org.demo.com.entities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InterReposetory extends JpaRepository<Book, Long> {
	

}
