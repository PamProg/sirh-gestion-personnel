package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;

@WebServlet("/collaborateurs/lister")
public class ListerCollaborateursController extends HttpServlet {

	@EJB private CollaborateurService collabService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
							throws ServletException, IOException {

		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();
		req.setAttribute("listeCollabs", collaborateurs);
		req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(req, resp);
	}
}
