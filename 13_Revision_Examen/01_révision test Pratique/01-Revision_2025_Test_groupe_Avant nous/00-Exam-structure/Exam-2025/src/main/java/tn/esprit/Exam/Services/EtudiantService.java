package tn.esprit.Exam.Services;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import tn.esprit.Exam.Entity.*;
import tn.esprit.Exam.Repository.EtudiantRepository;
import tn.esprit.Exam.Repository.CoursRepository;
import tn.esprit.Exam.Repository.DepartementRepository;

import java.time.LocalDate;
import java.util.List;


@org.springframework.stereotype.Service
@Slf4j
public class EtudiantService implements IEtudiantService {
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private CoursRepository coursRepository;
	@Autowired
	private DepartementRepository departementRepository;

	// 1) Ajouter Etudiant
	public Etudiant addEtudiant(Etudiant e) {
		return etudiantRepository.save(e);
	}
	// Pour ajouter les 2 étudiants spécifiques (à appeler manuellement ou via controller)
	// Exemple : addEtudiant(new Etudiant("Mohamed", LocalDate.parse("2023-09-01"), Niveau.PREMIER));
	// addEtudiant(new Etudiant("Meriam", LocalDate.parse("2023-09-01"), Niveau.TERMINAL));

	// 2) Ajouter Cours et Departement en même temps
	@Override
	public Cours addCoursAndDepart(Cours c) {
		Departement dep = c.getDepartement();
		if (dep != null && dep.getIdDepart() == null) {
			departementRepository.save(dep);
		}
		return coursRepository.save(c);
	}

	// 3) Ajouter Cours et assigner à un Departement existant
	@Override
	public Cours addCoursAndAssignToDepart(Cours c, Long idDepart) {
		Departement dep = departementRepository.findById(idDepart)
				.orElseThrow(() -> new RuntimeException("Departement not found"));
		c.setDepartement(dep);
		return coursRepository.save(c);
	}
	// 4) Affecter Cours à Etudiant (utiliser findBy pour "keywords")
	@Override
	public void affecterCoursToEtudiant(String nomCours, String nomEtudiant) {
		Cours cours = coursRepository.findByNomCours(nomCours);
		Etudiant etudiant = etudiantRepository.findByNomEtudiant(nomEtudiant);
		if (cours != null && etudiant != null) {
			cours.getEtudiants().add(etudiant);
			etudiant.getCours().add(cours);
			coursRepository.save(cours);
		}
	}
	// 5) Lister étudiants avec JPQL
	public List<Etudiant> retrieveEtudiant(Niveau n, LocalDate d, Specialite s) {
		return etudiantRepository.findByNiveauEtudeAndDateInscriAfterAndCoursDepartementSpecialite(n, d, s);
		// Note : Ajouter cette méthode query dans EtudiantRepository si non auto-générée :
		// @Query("SELECT e FROM Etudiant e JOIN e.cours c WHERE e.niveauEtude = :n AND e.dateInscri > :d AND c.departement.specialite = :s")
		// List<Etudiant> findByNiveauEtudeAndDateInscriAfterAndCoursDepartementSpecialite(@Param("n") Niveau n, @Param("d") LocalDate d, @Param("s") Specialite s);
	}
	// 6) Scheduler pour ordonner départements par nombre d'affectations
	@Scheduled(fixedRate = 20000)  // Toutes les 20 secondes
	public void ordonnerDepart() {
		// Utiliser JPQL pour compter
		// Exemple query dans DepartementRepository :
		// @Query("SELECT d, COUNT(e) FROM Departement d JOIN d.cours c JOIN c.etudiants e GROUP BY d ORDER BY COUNT(e) DESC")
		// List<Object[]> findDepartementsOrderedByInterest();
		List<Object[]> results = departementRepository.findDepartementsOrderedByInterest();
		for (Object[] row : results) {
			Departement d = (Departement) row[0];
			Long count = (Long) row[1];
			System.out.println("Departement: " + d.getNomDepart() + " - Interests: " + count);
		}
	}

	// 7) Désassigner Cours d'Etudiant
	public void disassignCoursFromEtudiant(String nomCours, String nomEtudiant) {
		Cours cours = coursRepository.findByNomCours(nomCours);
		Etudiant etudiant = etudiantRepository.findByNomEtudiant(nomEtudiant);
		if (cours != null && etudiant != null) {
			cours.getEtudiants().remove(etudiant);
			etudiant.getCours().remove(cours);  // Synchro bidirectionnelle
			coursRepository.save(cours);
		}
	}
}