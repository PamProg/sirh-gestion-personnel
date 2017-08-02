package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class NouveauCollaborateurController extends HttpServlet {

	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
							throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/collab/nouveauCollaborateur.jsp").forward(req, resp);
		 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
							throws ServletException, IOException {

		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String adresse = req.getParameter("adresse");
		String numeroDeSecuriteSociale = req.getParameter("nir");
		
		// TODO le mettre dans le service, ie : CollaborateurService
		// TODO mettre la vérification des infos dans le Service aussi
		String photo = "images/portrait/" + nom + ".jpg";
		ZonedDateTime dateHeureCreation = ZonedDateTime.now();
		Boolean actif = true;
		
		String societe = ResourceBundle.getBundle("application").getString("nomSociete");
		String emailPro = prenom + "." + nom + "@" + societe;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		formatter = formatter.withLocale(Locale.FRANCE);
		LocalDate dateDeNaissance = LocalDate.parse(req.getParameter("dateDeNaissance"), formatter);
		
		String matricule = UUID.randomUUID().toString();
		
		Collaborateur collab = new Collaborateur(matricule, nom, prenom, dateDeNaissance, adresse, numeroDeSecuriteSociale, emailPro, photo, dateHeureCreation, actif);
		
		collabService.sauvegarderCollaborateur(collab);
		
//		resp.sendRedirect("/sgp/collaborateurs/lister");
//		resp.sendRedirect("./lister");
		resp.sendRedirect("lister");
		 
	}
	
}
