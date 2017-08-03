package dev.sgp.entite;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Departement {

	@Id
	private Integer id;
	private String nom;
	
	public Departement() {
		
	}
	
	/**
	 * @param id
	 * @param nom
	 */
	public Departement(Integer id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
