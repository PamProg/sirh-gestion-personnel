package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Departement;

public class DepartementService {
	
	private List<Departement> listeDepartements = new ArrayList<>();
	
	public List<Departement> listerDepartements() {
		return listeDepartements;
	}

	public void sauvegarderDepartement(Departement depart) {
		listeDepartements.add(depart);
	}
}
