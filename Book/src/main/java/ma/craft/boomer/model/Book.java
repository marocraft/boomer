package ma.craft.boomer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
	@GeneratedValue
	private int bookId;
	private String bookLibelle;
	private String bookDescription;
	private String autor;
	private int quantite;

}
