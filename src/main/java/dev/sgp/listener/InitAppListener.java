package dev.sgp.listener;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.VisiteWebService;
import dev.sgp.util.Constantes;

public class InitAppListener implements HttpSessionListener {

	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
//	private VisiteWebService visiteService = Constantes.VISITE_SERVICE;
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		
		List<Collaborateur> collabs = initCollaborateurs();
		
		for(Collaborateur c : collabs) {
			collabService.sauvegarderCollaborateur(c);
		}
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		
	}


	private List<Collaborateur> initCollaborateurs() {
		List<Collaborateur> list = new ArrayList<>();
		list.add(new Collaborateur("1", "Albert", "Dupont", LocalDate.of(1993, 8, 26), "46 de la Boustifaille", "123456789123456", "mail@mail.com", "cheminDeLimage.jpg", ZonedDateTime.now(), true));
		for(int i=0 ; i<10 ; i++) {
			list.add(new Collaborateur("m"+i, "nom"+i, "prenom"+i, LocalDate.of(i, 8, 26), "adresse"+i, "1234567891234"+i, "mail"+i, "cheminPhoto"+i+".jpg", ZonedDateTime.now(), true));
		}
		return list;
	}
	
}
