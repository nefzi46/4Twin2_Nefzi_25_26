package tn.esprit.spring.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Film;
import tn.esprit.spring.entities.Salle;
import tn.esprit.spring.repositories.FilmRepository;
import tn.esprit.spring.repositories.SalleRepository;

@Service
public class FilmServiceImpl implements IFilmService {

	@Autowired
	FilmRepository fr;
	
	@Autowired
	SalleRepository sr;

	@Transactional
	@Override
	public void affecterFilmASalle(long filmId, long salleId) {
		Film f = fr.findById(filmId).get();
		Salle s = sr.findById(salleId).get();
		s.getFilms().add(f);
		//sr.save(s);
	}

	@Override
	public Film ajouterFilm(Film f) {
		return fr.save(f);
	}
}
