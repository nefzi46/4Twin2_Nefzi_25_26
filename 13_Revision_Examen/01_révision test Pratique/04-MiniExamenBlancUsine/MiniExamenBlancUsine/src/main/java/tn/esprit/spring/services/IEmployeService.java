package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Employe;

public interface IEmployeService {
	
	void ajouterEmployesEtAffecterAUsine(long usineId, List<Employe> employes);
	List<Employe> ListerEmploye();
}
