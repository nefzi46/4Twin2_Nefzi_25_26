package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Cinema;
import tn.esprit.spring.entities.Salle;
import tn.esprit.spring.repositories.CinemaRepository;
import tn.esprit.spring.repositories.SalleRepository;

@Service
public class SalleServiceImpl implements ISalleService {

	@Autowired
	SalleRepository sr;

	@Autowired
	CinemaRepository cr;

	@Override
	public void ajouterSalleEtAffecterCinema(Salle s, long cinemaId) {
		Cinema c = cr.findById(cinemaId).orElse(new Cinema());
		s.setCinema(c);
		sr.save(s);
	}

	@Override
	public List<Salle> ListerSalle(long cinemaId) {
		Cinema c = cr.findById(cinemaId).get();
		return sr.ListerSalle(c);
	}

	@Override
	public long NbreFilmAUneSalle(long salleId) {
		return sr.NbreFilmAUneSalle(salleId);
	}

}
