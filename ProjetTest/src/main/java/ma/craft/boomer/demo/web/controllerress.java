package ma.craft.boomer.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.craft.boomer.demo.Feign.RemoteCallService;
import ma.craft.boomer.demo.Service.TraitementMetier;
import ma.craft.boomer.demo.entities.Book;
import ma.craft.boomer.demo.entities.PromotionB;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class controllerress {

	@Autowired
	private TraitementMetier traitementMetier;

	@GetMapping(value = "book/{id}")
	public Book GetOneBook(@PathVariable Long id) {
		return traitementMetier.getBookById(id);
	}

	@Autowired
	private RemoteCallService remotecallservice;

	/************* Get Students from the others Service ****************/
	@GetMapping("book/search/{libelle}") 
	public Object getEmployee(@PathVariable("libelle") String libelle) 
	{
		return remotecallservice.getData(libelle);
	}

	@GetMapping(value = "books")
	public List<Book> AllBooks() {
		return traitementMetier.getAllBooks();
	}

	@GetMapping(value = "addbook/{libel}/{desc}/{autor}/{quant}")
	public void AddBook(@PathVariable String libel, @PathVariable String desc, @PathVariable String autor,
			@PathVariable int quant) {
		traitementMetier.AddBook(libel, desc, autor, quant);
	}

	// ***********************************************Promotion***************************
	// get Promotion
	@GetMapping(value = "promotion/{id}")
	public PromotionB GetOnePromotion(@PathVariable Long id) {
		return traitementMetier.getPromotionById(id);
	}

	// Add Promotion
	@RequestMapping(value = "/promotion", method = RequestMethod.POST)
	public void AddPromotion(@RequestBody PromotionB promotion) {
		traitementMetier.AddPromotionDate(promotion);
	}

	// Get All Promotions
	@GetMapping(value = "listPromotion")
	public List<PromotionB> AllPromotions() {
		return traitementMetier.getAllPromotion();
	}

	// get all promotion Valide
	@GetMapping(value = "listPromotionValid")
	public List<PromotionB> AllPromotionsValid() {
		return traitementMetier.getAllPromotionValide();
	}

	// Add Promotion
	@RequestMapping(value = "/validerpromotion", method = RequestMethod.PUT)
	public void ValiderPromotion(@RequestBody PromotionB prom) {
		traitementMetier.ValiderUnePromotion(prom);
	}

	// Bloquer Toutes les promotions
	@RequestMapping(value = "/BloquerToutespromotion", method = RequestMethod.PUT)
	public void BloquerToutespromotion() {
		traitementMetier.BloquerToutespromotion();
	}

	// Recherche des Books
	@GetMapping(value = "books/{mc}/type")
	public List<Book> ChercherBook(@PathVariable String mc, @PathVariable String type) {
		return traitementMetier.chercherBook(mc, type);
	}

}
