package org.demo.com.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PromotionA {
	@Id
	@GeneratedValue
	private Long id;
	private String datesebut;
	private String datefin;
	private String descrip;
	private int pourcentage;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDatesebut() {
		return datesebut;
	}
	public void setDatesebut(String datesebut) {
		this.datesebut = datesebut;
	}
	public String getDatefin() {
		return datefin;
	}
	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public int getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(int pourcentage) {
		this.pourcentage = pourcentage;
	}
	/**
	 * @param datesebut
	 * @param datefin
	 * @param descrip
	 * @param pourcentage
	 */
	public PromotionA(String datesebut, String datefin, String descrip, int pourcentage) {
		super();
		this.datesebut = datesebut;
		this.datefin = datefin;
		this.descrip = descrip;
		this.pourcentage = pourcentage;
	}
	/**
	 * 
	 */
	public PromotionA() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
