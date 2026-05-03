package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Usine;
import tn.esprit.spring.services.IUsineService;

@RestController
public class UsineRestController {
	
	@Autowired
	IUsineService us;
	
	@PostMapping("ajouterUsine")
	public Usine ajouterUsine(@RequestBody Usine u) {
		return us.ajouterUsine(u);
	}
	



}
