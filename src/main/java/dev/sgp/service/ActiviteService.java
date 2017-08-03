package dev.sgp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.sgp.entite.CollabEvt;

@Stateless
public class ActiviteService {
	
	@PersistenceContext private EntityManager em;

	public List<CollabEvt> listerActivitesCollab() {
		TypedQuery<CollabEvt> query = em.createQuery("select c from CollabEvt c", CollabEvt.class);
		List<CollabEvt> listeCollabEvts = query.getResultList();
		return listeCollabEvts;
	}
	
	public void recevoirEvenementCollab(@Observes CollabEvt evt) {
		em.persist(evt);
	}
}
