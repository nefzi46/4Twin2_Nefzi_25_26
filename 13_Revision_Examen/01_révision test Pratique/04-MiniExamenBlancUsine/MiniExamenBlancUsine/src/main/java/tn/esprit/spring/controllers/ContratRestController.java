package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;

@RestController
public class ContratRestController {

	@Autowired
	IContratService cs;
	
	
	@PostMapping("ajouterContrat")
	public Contrat ajouterContrat(@RequestBody Contrat c) {
		return cs.ajouterContrat(c);
	}
	
	@PutMapping("affecterContratAEmploye")
	public void affecterContratAEmploye(@RequestParam("contratId") long contratId, @RequestParam("employeId") long employeId) {
		cs.affecterContratAEmploye(contratId, employeId);
	}
}
	
