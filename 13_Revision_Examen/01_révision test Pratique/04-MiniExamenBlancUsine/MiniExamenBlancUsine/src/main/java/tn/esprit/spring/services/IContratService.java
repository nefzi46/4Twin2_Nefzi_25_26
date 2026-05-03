package tn.esprit.spring.services;

import tn.esprit.spring.entities.Contrat;

public interface IContratService {

	Contrat ajouterContrat (Contrat c);
	
	void affecterContratAEmploye(long contratId, long employeId);
}
