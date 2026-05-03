package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Salle;
import tn.esprit.spring.services.ISalleService;

@RestController
public class SalleRestController {

	@Autowired
	ISalleService ss;
	
	@PostMapping("ajouterSalleEtAffecterCinema")
	public void ajouterSalleEtAffecterCinema(@RequestBody Salle s, @RequestParam("cinemaId") long cinemaId) {
		ss.ajouterSalleEtAffecterCinema(s, cinemaId);
	}
	
	@GetMapping("ListerSalle")
	public List<Salle> ListerSalle(@RequestParam("cinemaId") long cinemaId) {
		return ss.ListerSalle(cinemaId);
	}
	
	@GetMapping("NbreFilmAUneSalle")
	public long NbreFilmAUneSalle(@RequestParam("salleId") long salleId) {
		return ss.NbreFilmAUneSalle(salleId);
	}


}
