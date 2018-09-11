package ma.craft.boomer.demo.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PromotionB {
	@Id
	@GeneratedValue
	private Long id;
	private String datedebut;
	private String datefin;
	private String description;
	private int pourcentage;
	private boolean valide;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(String datedebut) {
		this.datedebut = datedebut;
	}
	public String getDatefin() {
		return datefin;
	}
	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(int pourcentage) {
		this.pourcentage = pourcentage;
	}
	public boolean getValide() {
		return valide;
	}
	public void setValide(boolean valide) {
		this.valide = valide;
	}
	/**
	 * @param datedebut
	 * @param datefin
	 * @param description
	 * @param pourcentage
	 * @param valide
	 */
	public PromotionB(String datedebut, String datefin, String description, int pourcentage, boolean valide) {
		super();
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.description = description;
		this.pourcentage = pourcentage;
		this.valide = valide;
	}
	
	public PromotionB() {
		super();
	}
	

	
}
