package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Usine;
import tn.esprit.spring.repositories.EmployeRepository;
import tn.esprit.spring.repositories.UsineRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	
	@Autowired
	EmployeRepository er;
	
	@Autowired
	UsineRepository ur;
	
	@Transactional
	@Override
	public void ajouterEmployesEtAffecterAUsine(long usineId, List<Employe> employes) {
		Usine u = ur.findById(usineId).get();
		u.getEmployes().addAll(employes);
		//ur.save(u);
	}

	@Override
	public List<Employe> ListerEmploye() {
		return er.ListerEmploye(new Date());
	}

}
