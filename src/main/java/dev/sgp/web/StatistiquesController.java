package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteWebService;

@WebServlet("/statistiques")
public class StatistiquesController extends HttpServlet {
	
	@Inject private VisiteWebService visiteService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
							throws ServletException, IOException {

		List<VisiteWeb> visites = visiteService.listerVisites();
		
		// Pour faire les statistiques poussées
//		Map<String, List<VisiteWeb>> visitesGroupeesChemin = visites.stream().collect(Collectors.groupingBy(VisiteWeb::getChemin));
		
		req.setAttribute("listeVisites", visites);
		req.getRequestDispatcher("/WEB-INF/views/statistiques.jsp").forward(req, resp);
		 
	}
}
