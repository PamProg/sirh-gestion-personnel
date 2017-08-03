package dev.sgp.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;
import dev.sgp.exception.NirDontMatchException;

@ApplicationScoped
public class CollaborateurService {

	private List<Collaborateur> listeCollaborateurs = new ArrayList<>();
	@Inject Event<CollabEvt> collabEvt;
	
	public List<Collaborateur> listerCollaborateurs() {
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
		
		listeCollaborateurs.add(collab);
		
		collabEvt.fire(new CollabEvt(collab.getDateHeureCreation(), TypeCollabEvt.CREATION_COLLAB, collab.getMatricule()));
	}
}
