package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repositories.ContratRepository;
import tn.esprit.spring.repositories.EmployeRepository;

@Service
public class ContratServiceImpl implements IContratService {

	
	@Autowired
	ContratRepository cr;
	
	@Autowired
	EmployeRepository er;
	
	@Override
	public Contrat ajouterContrat(Contrat c) {
		return cr.save(c);
	}

	@Override
	public void affecterContratAEmploye(long contratId, long employeId) {
		Employe e = er.findById(employeId).get();
		Contrat c = cr.findById(contratId).get();
		e.setContrat(c);
		er.save(e);
	}

}
