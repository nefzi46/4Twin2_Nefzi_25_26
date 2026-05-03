package tn.esprit.spring.services;

import tn.esprit.spring.entities.Film;

public interface IFilmService {

	void affecterFilmASalle(long filmId, long salleId);
	Film ajouterFilm (Film f);

}
