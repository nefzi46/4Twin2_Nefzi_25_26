package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Usine;
import tn.esprit.spring.repositories.UsineRepository;

@Service
public class UsineServiveImpl implements IUsineService {

	@Autowired
	UsineRepository ur;

	@Override
	public Usine ajouterUsine(Usine u) {
		return ur.save(u);
	}

}
