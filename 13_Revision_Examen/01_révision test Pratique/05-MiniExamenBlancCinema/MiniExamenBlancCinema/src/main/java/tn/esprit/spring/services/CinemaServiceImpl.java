package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Cinema;
import tn.esprit.spring.repositories.CinemaRepository;

@Service
public class CinemaServiceImpl implements ICinemaService {

	@Autowired
	CinemaRepository cr;

	@Override
	public Cinema ajouterCinema(Cinema c) {
		return cr.save(c);
	}
}
