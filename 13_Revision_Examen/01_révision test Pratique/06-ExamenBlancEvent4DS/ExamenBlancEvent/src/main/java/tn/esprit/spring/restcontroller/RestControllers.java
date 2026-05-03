package tn.esprit.spring.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Activite;
import tn.esprit.spring.entities.Evenement;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IServices;

@RestController
@Slf4j
public class RestControllers {

	@Autowired
	IServices iservices;

	@PostMapping("addEvenement")
	public Evenement addEvenement(@RequestBody Evenement e) {
		return iservices.addEvenement(e);
	}
	
	@PostMapping("addActivite")
	public Activite addActivite(@RequestBody Activite a) {
		return iservices.addActivite(a);
	}

	@PutMapping("affectActiviteToEvent/{activiteId}/{eventId}")
	public void affectActiviteToEvent(Long activiteId, Long eventId) {
		iservices.affectActiviteToEvent(activiteId, eventId);
	}

	@PostMapping("addUser/{idEvent}")
	public String addUser(@RequestBody User u, @PathVariable Long idEvent) {
		return iservices.addUser(u, idEvent);
	}

	@GetMapping("getEventsByResponsable/{responsableId}")
	public List<Evenement> getEventsByResponsable(@PathVariable Long responsableId) {
		return iservices.getEventsByResponsable(responsableId);
	}

	@Scheduled(cron = "0/30 * * * * *")
	public void getEventsOfToday() {
		List<Evenement> list = iservices.getEventsOfToday();
		log.info("*********** Evenements d'aujourd'hui ***********");
		for (Evenement evenement : list) {
			log.info("Libelle => "+evenement.getLibelle()+", Description => "+evenement.getDescription());
		}
	}

}
