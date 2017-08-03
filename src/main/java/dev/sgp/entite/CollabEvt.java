package dev.sgp.entite;

import java.time.ZonedDateTime;

public class CollabEvt {

	private ZonedDateTime dateHeure;
	private TypeCollabEvt type;
	private String matricule;
	
	/**
	 * @param dateHeure
	 * @param type
	 * @param matricule
	 */
	public CollabEvt(ZonedDateTime dateHeure, TypeCollabEvt type, String matricule) {
		this.dateHeure = dateHeure;
		this.type = type;
		this.matricule = matricule;
	}
	
	/**
	 * @return the dateHeure
	 */
	public ZonedDateTime getDateHeure() {
		return dateHeure;
	}
	/**
	 * @param dateHeure the dateHeure to set
	 */
	public void setDateHeure(ZonedDateTime dateHeure) {
		this.dateHeure = dateHeure;
	}
	/**
	 * @return the type
	 */
	public TypeCollabEvt getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(TypeCollabEvt type) {
		this.type = type;
	}
	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}
	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
}
