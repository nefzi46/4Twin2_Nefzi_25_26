package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Activite;
import tn.esprit.spring.entities.Evenement;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.ActiviteRepository;
import tn.esprit.spring.repositories.EvenementRepository;
import tn.esprit.spring.repositories.UserRepository;

@Service
@Slf4j
public class Services implements IServices {

	@Autowired
	UserRepository userRepository;
	@Autowired
	ActiviteRepository activiteRepository;
	@Autowired
	EvenementRepository evenementRepository;

	@Override
	public Evenement addEvenement(Evenement e) {
		return evenementRepository.save(e);
	}
	
	@Override
	public Activite addActivite(Activite a) {
		return activiteRepository.save(a);
	}

	@Override
	public void affectActiviteToEvent(Long activiteId, Long eventId) {
		Evenement e = evenementRepository.findById(eventId).get();
		Activite a = activiteRepository.findById(activiteId).get();
		a.setEvenement(e);
		activiteRepository.save(a);
	}
	
	@Override
	public String addUser(User u, Long idEvent) {
		Evenement e = evenementRepository.findById(idEvent).get();
		if (u.getRole() == Role.PARTICIPANT) {
			if (e.getNbParticipants()>=e.getUsersP().size()) {
				u.getEvenementsP().add(e);
				userRepository.save(u);
				return "L'affectation du participant est effectuée avec succès ";
			}
			else {
				return "l'évènement est complet !";
				
			}
		} else if (u.getRole() == Role.RESPONSABLE)
		{
			if (e.getUserR()==null) {
				e.setUserR(u);
				evenementRepository.save(e);
				return "L'affectation du responsable est effectuée avec succès ";			}
			else {
				return "Il y a déjà un responsable !";
			}
		}
		return "Problème !!";
	}

	@Override
	public List<Evenement> getEventsByResponsable(Long responsableId) {
		User u = userRepository.findById(responsableId).get();
		return u.getEvenementsR();
	}

	@Override
	public List<Evenement> getEventsOfToday() {
		return evenementRepository.findByDateEvent(new Date());
	}



}
