package dev.sgp.listener;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.exception.NirDontMatchException;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;

@WebListener
public class InitAppListener implements ServletContextListener {

	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	private DepartementService departService = Constantes.DEPART_SERVICE;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<Collaborateur> collabs = initCollaborateurs();
		for (Collaborateur c : collabs) {
			try {
				collabService.sauvegarderCollaborateur(c);
			} catch (NirDontMatchException e) {
				e.printStackTrace();
			}
		}
		
		List<Departement> departements = initDepartements();
		for(Departement d : departements) {
			departService.sauvegarderDepartement(d);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}
	
	private List<Collaborateur> initCollaborateurs() {
		List<Collaborateur> list = new ArrayList<>();
		list.add(new Collaborateur("1", "Albert", "Dupont", LocalDate.of(1993, 8, 26), "46 de la Boustifaille",
				"123456789123456", "mail@mail.com", "cheminDeLimage.jpg", ZonedDateTime.now(), true, new Departement(1, "Informatique"), "Développeur"));
		for (int i = 0; i < 10; i++) {
			list.add(new Collaborateur("m" + i, "nom" + i, "prenom" + i, LocalDate.of(i, 8, 26), "adresse" + i,
					"123456789123456", "mail" + i, "cheminPhoto" + i + ".jpg", ZonedDateTime.now(), true, new Departement(i, "Comptabilité"), "Comptable"));
		}
		return list;
	}
	
	private List<Departement> initDepartements() {
		List<Departement> list = new ArrayList<>();
		
		list.add(new Departement(1, "Comptabilité"));
		list.add(new Departement(2, "Ressources Humaines"));
		list.add(new Departement(3, "Informatique"));
		list.add(new Departement(4, "Administratif"));
		
		return list;
	}
}
