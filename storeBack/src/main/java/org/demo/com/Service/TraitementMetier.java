package org.demo.com.Service;

import java.util.Date;
import java.util.List;

import org.demo.com.entities.Book;
import org.demo.com.entities.InterRepoPromotion;
import org.demo.com.entities.InterReposetory;
import org.demo.com.entities.PromotionA;
import org.demo.com.entities.PromotionA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Service
public class TraitementMetier {
	
	@Autowired
	 private InterReposetory interrepobook ;
	@Autowired
	private InterRepoPromotion interrepopromotion;
	
	//******************************************* Book******************************
	//get one book by id
	public Book getBookById(Long id) {		
		return interrepobook.getOne(id);
	}
	// get all books 
	public List<Book> getAllBooks(){		
		return interrepobook.findAll() ;
	}
	// Add book
	public void AddBook(String libel, String desc, String autor, int quantite){		
		interrepobook.save(new Book(libel, autor, desc, quantite));
	}
	
	//*****************************************Promotion****************************
	//get all promotions
	public List<PromotionA> getAllPromotion(){		
		return interrepopromotion.findAll() ;
	}
	//Add promotion
	public void AddPromotionDate (String datesebut, String datefin, String descrip, int pourcentage){		
		interrepopromotion.save(new PromotionA(datesebut, datefin, descrip, pourcentage));
	}

	
}
