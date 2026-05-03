package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IEmployeService;

@RestController
@Slf4j
public class EmployeRestController {
	
	@Autowired
	IEmployeService es;

	@PostMapping("ajouterEmployesEtAffecterAUsine")
	public void ajouterEmployesEtAffecterAUsine(@RequestParam("usineId") long usineId, @RequestBody List<Employe> employes) {
		es.ajouterEmployesEtAffecterAUsine(usineId, employes);
	}
	
	@Scheduled(fixedRate = 10000) //10 secondes
	public void ListerEmploye() {
		log.info("Scheduled ListerEmploye lancé ");
		log.info("Size => "+es.ListerEmploye().size());
		for (Employe e : es.ListerEmploye()) {
			log.info(e.toString());
		}
		
	}
}
