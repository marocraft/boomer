package org.demo.com.web;


import java.util.Date;
import java.util.List;

import org.demo.com.Service.TraitementMetier;
import org.demo.com.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders="*")
public class controllerress {

	@Autowired
	 private TraitementMetier traitementMetier;
	
	@GetMapping(value="book/{id}")
	public Book GetOneBook(@PathVariable Long id) {
		return traitementMetier.getBookById(id);
	}
	
	@GetMapping(value="books")
	public List<Book> AllBooks() {
		return traitementMetier.getAllBooks();
	}
	
	
	
	@GetMapping(value="addbook/{libel}/{desc}/{autor}/{quant}")
	public void AddBook(@PathVariable String libel, @PathVariable String desc,
			@PathVariable String autor, @PathVariable int quant) {
		traitementMetier.AddBook(libel, desc, autor, quant);
		
	}
	
	@GetMapping(value="book/{datesebut}/{datefin}/{descrip}/{pourcentage}")
	public void AddPromotion(@PathVariable String datesebut, @PathVariable String datefin,
			@PathVariable String descrip, @PathVariable int pourcentage) {
		traitementMetier.AddPromotionDate(datesebut, datefin, descrip, pourcentage);
		
	}
	
}
