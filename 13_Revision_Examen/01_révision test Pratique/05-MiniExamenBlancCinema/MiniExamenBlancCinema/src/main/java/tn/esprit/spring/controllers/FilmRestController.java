package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Film;
import tn.esprit.spring.services.IFilmService;

@RestController
public class FilmRestController {
	
	@Autowired
	IFilmService fs;
	
	@PutMapping("affecterFilmASalle")
	public void affecterFilmASalle(@RequestParam("filmId") long filmId, @RequestParam("salleId") long salleId) {
		fs.affecterFilmASalle(filmId, salleId);
	}
	
	@PostMapping("ajouterFilm")
	public Film ajouterFilm (@RequestBody Film f) {
		return fs.ajouterFilm(f);
	}


}
