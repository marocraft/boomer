package ma.craft.boomer.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.craft.boomer.demo.entities.Book;
import ma.craft.boomer.demo.entities.InterRepoPromotion;
import ma.craft.boomer.demo.entities.InterReposetory;
import ma.craft.boomer.demo.entities.PromotionB;

@Service
public class TraitementMetier {
	
	@Autowired
	 private InterReposetory interrepobook ;
	@Autowired
	private InterRepoPromotion interrepopromotion;
	/**
	 * get one book by id
	 * @param id
	 * @return
	 */
	public Book getBookById(Long id) {		
		return interrepobook.getOne(id);
	}
	// get all books 
	public List<Book> getAllBooks(){		
		return interrepobook.findAll() ;
	}
	// Add book
	public void addBook(String libel, String desc, String autor, int quantite){		
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
	public void addPromotionDate (PromotionB promotion){		
		 interrepopromotion.save(promotion);
	}
	//get all promotion valide
	public List<PromotionB> getAllPromotionValide(){
		List<PromotionB> lsvalide = new ArrayList<PromotionB>();
		List<PromotionB> ls = getAllPromotion();
		for (PromotionB promotionB : ls) {
			if(promotionB.getValide()==true) {
				lsvalide.add(promotionB);
			}
		}
		return lsvalide;
	}

	//valider promotion
	public void validerUnePromotion(PromotionB prom){
		List<PromotionB> ls = getAllPromotion();
		for (PromotionB promotionB : ls) {
			if(promotionB.getId()==prom.getId()) {
				
				
				promotionB.setValide(true);
				interrepopromotion.save(promotionB);
			}
			if(promotionB.getValide() == true && promotionB.getId()!=prom.getId()) {				
				promotionB.setValide(false);	
				interrepopromotion.save(promotionB);
			}
			
		}
		
	}
	// Bloquer toutes les promotions
	public void bloquerToutespromotion(){
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
		}
		return ls;
		
			
		}
		
	}
	
	
	
	
	
	
	
	
	

