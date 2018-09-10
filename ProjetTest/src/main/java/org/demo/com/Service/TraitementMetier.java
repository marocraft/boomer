package org.demo.com.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.demo.com.entities.Book;
import org.demo.com.entities.InterRepoPromotion;
import org.demo.com.entities.InterReposetory;
import org.demo.com.entities.PromotionB;
import org.demo.com.entities.PromotionB;
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
	public List<PromotionB> getAllPromotion(){		
		return interrepopromotion.findAll() ;
	}
	public PromotionB getPromotionById(Long id) {		
		return interrepopromotion.getOne(id);
	}
	//Add promotion
	public void AddPromotionDate (PromotionB promotion){		
		 interrepopromotion.save(promotion);
	}
	//get all promotion valide
	public List<PromotionB> getAllPromotionValide(){
		List<PromotionB> lsvalide = new ArrayList<PromotionB>();
		List<PromotionB> ls = getAllPromotion();
		for (PromotionB promotionB : ls) {
			if(promotionB.GetValide()==true) {
				lsvalide.add(promotionB);
			}
		}
		return lsvalide;
	}

	//valider promotion
	public void ValiderUnePromotion(PromotionB prom){
		//List<PromotionB> lsvalide = new ArrayList<PromotionB>();
		List<PromotionB> ls = getAllPromotion();
		for (PromotionB promotionB : ls) {
			if(promotionB.getId()==prom.getId()) {
				
				
				promotionB.setValide(true);
				interrepopromotion.save(promotionB);
			}
			if(promotionB.GetValide()==true && promotionB.getId()!=prom.getId()) {				
				promotionB.setValide(false);	
				interrepopromotion.save(promotionB);
			}
			
		}
		
	}
	// Bloquer toutes les promotions
	public void BloquerToutespromotion(){
		//List<PromotionB> lsvalide = new ArrayList<PromotionB>();
		List<PromotionB> ls = getAllPromotion();
		for (PromotionB promotionB : ls) {
			promotionB.setValide(false);	
			interrepopromotion.save(promotionB);
			}
			
			
		}
	//chercher un book
	public List<Book> chercherBook(String motcle, String type){
		List<Book> booksLibelli  = new ArrayList<>();
		List<Book> booksAutor  = new ArrayList<>();
		List<Book> ls = getAllBooks();
		if(type.equals("libelli")) {
		for (Book book : ls) {
			if(book.getLibelli().contains(motcle)) {
				booksLibelli.add(book);
			}			
		   }
		return booksLibelli;
		}else if(type.equals("autor")) {
			for (Book book : ls) {
				if(book.getAutor().contains(motcle)) {
					booksAutor.add(book);
				}			
			   }
			return booksAutor;
		}else
			
			return null;
		}
		
	}
	
	
	
	
	
	
	
	
	

