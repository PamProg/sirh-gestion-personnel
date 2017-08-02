package dev.sgp.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
							throws ServletException, IOException {
		
		String matriculeParam = req.getParameter("matricule");
		
		if(matriculeParam == null) {
			resp.setContentType("text/html");
			resp.sendError(400, "Un matricule est attendu");
		} else {
			resp.setContentType("text/html");
			resp.getWriter().write("<h1>Edition de collaborateur</h1>" + "<p>Matricule : " + matriculeParam + "</p>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
							throws ServletException, IOException {
		
		String matriculeParam = req.getParameter("matricule");
		String titreParam = req.getParameter("titre");
		String nomParam = req.getParameter("nom");
		String prenomParam = req.getParameter("prenom");
		
		List<String> paramsNull = Stream.of("matricule", "titre", "nom", "prenom")
									.filter(p -> req.getParameter(p) == null)
									.collect(Collectors.toList());
		
		List<String> params = Arrays.asList(matriculeParam, titreParam, nomParam, prenomParam);
		
		if(paramsNull.isEmpty()) {
			resp.setContentType("text/html");
			resp.setStatus(201);
			
			params.stream().forEach(resp.getWriter()::write);
		} else {
			resp.setContentType("text/html");
			resp.setStatus(400);
			resp.getWriter().write("Les paramètres suivants sont incorrects :");
			paramsNull.stream().forEach(resp.getWriter()::write);
		}
	}
}
