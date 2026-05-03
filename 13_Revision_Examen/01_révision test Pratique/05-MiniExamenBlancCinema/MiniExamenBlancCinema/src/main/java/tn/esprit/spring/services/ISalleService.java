package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Salle;

public interface ISalleService {
	
	void ajouterSalleEtAffecterCinema (Salle s, long cinemaId);
	List<Salle> ListerSalle (long cinemaId);
	long NbreFilmAUneSalle(long salleId);

}
