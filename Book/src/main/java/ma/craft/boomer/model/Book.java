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

	private Book(String bookLibelle,
			 String bookDescription,
			 String autor,
			 int quantite,
			 double prix){
		this.bookLibelle = bookLibelle;
		this.autor = autor;
		this.quantite = quantite;
		this.prix = prix;
		this.bookDescription = bookDescription;
	}

	public static class BookBuilder {
		private String bookLibelle;
		private String bookDescription;
		private String autor;
		private int quantite;
		private double prix;

		private BookBuilder(){}

		public static BookBuilder create(){
			return new BookBuilder();
		}

		public BookBuilder libelle(String libelle){
			this.bookLibelle = libelle;
			return this;
		}

		public BookBuilder quantite(int quantite){
			this.quantite = quantite;
			return this;
		}

		public BookBuilder autor(String autor){
			this.autor = autor;
			return this;
		}

		public BookBuilder prix(double prix){
			this.prix = prix;
			return this;
		}

		public BookBuilder description(String bookDescription){
			this.bookDescription = bookDescription;
			return this;
		}

		public Book build(){
			return new Book( bookLibelle, bookDescription, autor, quantite, prix);
		}
	}

}
