package ma.craft.boomer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bookId;
	
	private String bookLibelle;
	
	private String bookDescription;
	
	private String autor;
	
	private int quantite;
	
	private double prix;
	
	/**
	 * Instantiates a new book.
	 *
	 * @param bookLibelle the book libelle
	 * @param bookDescription the book description
	 * @param autor the autor
	 * @param quantite the quantite
	 */
	public Book(String bookLibelle, String bookDescription, String autor, int quantite,double prix,Long id) {
		this.bookId=id;
		this.bookLibelle = bookLibelle;
		this.bookDescription = bookDescription;
		this.autor = autor;
		this.quantite = quantite;
		this.prix=prix;
	}

//	public boolean equals(Object o) {
//		return false;
//	}
	
}
