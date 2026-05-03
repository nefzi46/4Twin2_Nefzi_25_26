package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Activite;
import tn.esprit.spring.entities.Evenement;
import tn.esprit.spring.entities.User;

public interface IServices {
	
	Evenement addEvenement(Evenement e);
	Activite addActivite(Activite a);
	void affectActiviteToEvent(Long activiteId,Long eventId);
	String addUser(User u, Long idEvent);
	List<Evenement> getEventsByResponsable(Long responsableId);
	List<Evenement> getEventsOfToday();
	
}
