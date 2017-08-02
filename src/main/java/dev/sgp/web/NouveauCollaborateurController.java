package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.exception.NirDontMatchException;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

@WebServlet("/collaborateurs/nouveau")
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

		String matricule = null;
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String adresse = req.getParameter("adresse");
		String numeroDeSecuriteSociale = req.getParameter("nir");
		String emailPro = null;
		String photo = null;
		ZonedDateTime dateHeureCreation = null;
		Boolean actif = null;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		formatter = formatter.withLocale(Locale.FRANCE);
		LocalDate dateDeNaissance = LocalDate.parse(req.getParameter("dateDeNaissance"), formatter);
		
		Collaborateur collab = new Collaborateur(matricule, nom, prenom, dateDeNaissance, adresse, numeroDeSecuriteSociale, emailPro, photo, dateHeureCreation, actif);
		
		try {
			collabService.sauvegarderCollaborateur(collab);
			resp.sendRedirect("/sgp/collaborateurs/lister");
		} catch (NirDontMatchException e) {
			Map<String, String> listErreurs = new HashMap<>();
			listErreurs.put("nir", "Le NIR doit contenir exactement 15 caractères");
			req.setAttribute("listErreurs", listErreurs);
			doGet(req, resp);
		}
		 
	}
}
