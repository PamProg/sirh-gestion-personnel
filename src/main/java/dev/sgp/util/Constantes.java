package dev.sgp.util;

import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.service.VisiteWebService;

public interface Constantes {
	public static final CollaborateurService COLLAB_SERVICE = new CollaborateurService();
	public static final DepartementService DEPART_SERVICE = new DepartementService();
	public static final VisiteWebService VISITE_SERVICE = new VisiteWebService();
}
