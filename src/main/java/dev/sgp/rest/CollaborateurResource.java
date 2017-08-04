package dev.sgp.rest;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;

@Path("/collaborateurs")
public class CollaborateurResource {

	@EJB private CollaborateurService collabService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Collaborateur> listByDepartement(@QueryParam("departement") Integer departementId) {
		if(departementId != null) {
			return collabService.listByDepartement(departementId);
		}
		return collabService.listerCollaborateurs();
	}
	
	@GET
	@Path("/{matricule}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collaborateur collabByMatricule(@PathParam("matricule") String mat) {
		return collabService.findByMatricule(mat);
	}
	
	@PUT
	@Path("/{matricule}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void modify(@PathParam("matricule") String matricule, Collaborateur collab) {
		collabService.updateCollab(matricule, collab);
	}
	
	@GET
	@Path("/{matricule}/banque")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> getCoordonneesBancaire(@PathParam("matricule") String mat) {
		return collabService.getCoordonneesBancaire(mat);
	}

	@PUT
	@Path("/{matricule}/banque")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void modifyBanque(@PathParam("matricule") String matricule, Map<String, String> coordonnees) {
		collabService.updateCoordonneesBancaire(matricule, coordonnees);
	}
	
	
}
































