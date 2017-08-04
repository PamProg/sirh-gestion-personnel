package dev.sgp.service;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		return query.getResultList(); 
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

	public List<Collaborateur> listByDepartement(Integer departementId) {
		TypedQuery<Collaborateur> query = em.createQuery("select c from Collaborateur c where c.departement.id=:departementId", Collaborateur.class)
											.setParameter("departementId", departementId);
		return query.getResultList();
	}

	public Collaborateur findByMatricule(String mat) {
		TypedQuery<Collaborateur> query = em.createQuery("select c from Collaborateur c where c.matricule=:mat", Collaborateur.class)
											.setParameter("mat", mat);
		return query.getSingleResult();
	}

	// TODO : vérifier que les champs nom, prenom, adresse, nir ne soient pas modifiables
	public void updateCollab(String mat, Collaborateur collab) {
		// On récupère le collaborateur de matricule mat
		TypedQuery<Integer> query = em.createQuery("select c.id from Collaborateur c where c.matricule=:mat", Integer.class)
									  .setParameter("mat", mat);
		Integer id = query.getSingleResult();
		
		// Si il existe...
		if(id != null) {
			// ...on remplace son id par l'id du "nouveau" collaborateur...
			collab.setId(id);
			// ...puis on "écrase" les données du nouveau collaborateur dans celui en base
			em.merge(collab);
		} // TODO gérer le else{}
	}

	public Map<String, String> getCoordonneesBancaire(String mat) {
		TypedQuery<Collaborateur> query = em.createQuery("select c from Collaborateur c where c.matricule=:mat", Collaborateur.class)
				  .setParameter("mat", mat);
		
		Collaborateur col = query.getSingleResult();
		Map<String, String> map = new HashMap<>();
		map.put("banque", col.getBanque());
		map.put("bic", col.getBic());
		map.put("iban", col.getIban());
		return map;	
	}

	public void updateCoordonneesBancaire(String mat, Map<String, String> coordonnees) {
		TypedQuery<Collaborateur> query = em.createQuery("select c from Collaborateur c where c.matricule=:mat", Collaborateur.class)
				.setParameter("mat", mat);
		Collaborateur c = query.getSingleResult();
		
		c.setBanque(coordonnees.get("banque"));
		c.setBic(coordonnees.get("bic"));
		c.setIban(coordonnees.get("iban"));
		em.persist(c);
	}
}
