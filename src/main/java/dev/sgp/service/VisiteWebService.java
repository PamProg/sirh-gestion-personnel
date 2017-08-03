package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.sgp.entite.VisiteWeb;

@ApplicationScoped
public class VisiteWebService {

	private List<VisiteWeb> listeVisites = new ArrayList<>();

	public List<VisiteWeb> listerVisites() {
		return listeVisites;
	}

	public void sauvegarderVisite(VisiteWeb visite) {
		listeVisites.add(visite);
	}
}
