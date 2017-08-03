package dev.sgp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.sgp.entite.VisiteWeb;

@Stateless
public class VisiteWebService {

	@PersistenceContext private EntityManager em;

	public List<VisiteWeb> listerVisites() {
		TypedQuery<VisiteWeb> query = em.createQuery("select v from VisiteWeb v", VisiteWeb.class);
		return query.getResultList();
	}

	public void sauvegarderVisite(VisiteWeb visite) {
		em.persist(visite);
	}
}
