package dev.sgp.service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;
import dev.sgp.exception.NirDontMatchException;

@Stateless
public class CollaborateurService {

	@PersistenceContext private EntityManager em;
	@Inject Event<CollabEvt> collabEvt;
	
	public List<Collaborateur> listerCollaborateurs() {
		TypedQuery<Collaborateur> query = em.createQuery("select c from Collaborateur c", Collaborateur.class);
		List<Collaborateur> listeCollaborateurs = query.getResultList(); 
		return listeCollaborateurs;
	}

	public void sauvegarderCollaborateur(Collaborateur collab) throws NirDontMatchException {
		
		collab.setDateHeureCreation(ZonedDateTime.now());
		collab.setActif(true);
		collab.setMatricule(UUID.randomUUID().toString());
		String societe = ResourceBundle.getBundle("application").getString("nomSociete");
		collab.setEmailPro(collab.getPrenom().toLowerCase() + "." + collab.getNom().toLowerCase() + "@" + societe);
		
		if(!collab.getNumeroDeSecuriteSociale().matches("\\w{15}")) {
			throw new NirDontMatchException("Le NIR doit compotrer exactement 15 caractères");
		}
		
		em.persist(collab);
		
		collabEvt.fire(new CollabEvt(collab.getDateHeureCreation(), TypeCollabEvt.CREATION_COLLAB, collab.getMatricule()));
	}
}
