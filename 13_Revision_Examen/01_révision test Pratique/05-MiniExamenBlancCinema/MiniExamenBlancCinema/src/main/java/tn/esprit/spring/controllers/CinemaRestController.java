package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Cinema;
import tn.esprit.spring.services.ICinemaService;

@RestController
public class CinemaRestController {
	
	@Autowired
	ICinemaService cs;
	
	@PostMapping("ajouterCinema")
	public Cinema ajouterCinema(@RequestBody Cinema c) {
		return cs.ajouterCinema(c);
	}

}
