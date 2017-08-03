package dev.sgp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.sgp.entite.Departement;

@Stateless
public class DepartementService {
	
	@PersistenceContext private EntityManager em;
	
	public List<Departement> listerDepartements() {
		TypedQuery<Departement> query = em.createQuery("select d from Departement d", Departement.class);
		List<Departement> listeDepartements = query.getResultList();
		return listeDepartements;
	}

	public void sauvegarderDepartement(Departement depart) {
		em.persist(depart);
	}
}
