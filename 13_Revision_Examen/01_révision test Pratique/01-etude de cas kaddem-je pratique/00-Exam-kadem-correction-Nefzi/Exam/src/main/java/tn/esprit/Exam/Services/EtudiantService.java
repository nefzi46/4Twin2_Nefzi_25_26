package tn.esprit.Exam.Services;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.Exam.Entity.Departement;
import tn.esprit.Exam.Entity.Etudiant;
import tn.esprit.Exam.Entity.Option;
import tn.esprit.Exam.Repository.EtudiantRepo;
import tn.esprit.Exam.Repository.DepartementRepo;
import tn.esprit.Exam.Repository.EquipeRepo;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j

public class EtudiantService implements IEtudiantService {
	EtudiantRepo etudiantRepository;

	@Override
	public List<Etudiant> retrieveAllEtudiants() {
		return etudiantRepository.findAll();
	}

	@Override
	public Etudiant addEtudiant(Etudiant e) {
		return etudiantRepository.save(e);
	}

	@Override
	public Etudiant updateEtudiant(Etudiant e) {
		return etudiantRepository.save(e);
	}

	@Override
	public Etudiant retrieveEtudiant(Integer idEtudiant) {
		return etudiantRepository.findById(idEtudiant).orElse(null);
	}

	@Override
	public void removeEtudiant(Integer idEtudiant) {
		etudiantRepository.deleteById(idEtudiant);
	}

	@Override
	public Etudiant addAndAssignEtudiant(Etudiant e, Option o, Departement d) {
		e.setOption(o);
		e.setDepartement(d);
		return etudiantRepository.save(e);
	}
}