package dev.sgp.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

import dev.sgp.entite.Collaborateur;
import dev.sgp.exception.NirDontMatchException;

public class CollaborateurService {

	private List<Collaborateur> listeCollaborateurs = new ArrayList<>();

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
	}
}
