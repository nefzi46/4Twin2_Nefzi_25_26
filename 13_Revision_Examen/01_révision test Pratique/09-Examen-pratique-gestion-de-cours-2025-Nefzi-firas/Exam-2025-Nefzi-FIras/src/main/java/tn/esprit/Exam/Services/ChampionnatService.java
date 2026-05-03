package tn.esprit.Exam.Services;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.Exam.Entity.*;
import tn.esprit.Exam.Repository.ChampionnatRepository;
import tn.esprit.Exam.Repository.CourseRepository;


@org.springframework.stereotype.Service
@Slf4j
public class ChampionnatService implements IChampionnatService {
	@Autowired
	private ChampionnatRepository championnatRepository;
	@Autowired
	private CourseRepository courseRepository;

	// 1) Ajouter Etudiant
	public Championnat addChampionnat(Championnat e) {
		return championnatRepository.save(e);
	}
//	public Pilote addPilote(Pilote p) {
//		return piloteRepository.save(p);
//	}


	// Pour ajouter les 2 étudiants spécifiques (à appeler manuellement ou via controller)
	// Exemple : addEtudiant(new Etudiant("Mohamed", LocalDate.parse("2023-09-01"), Niveau.PREMIER));
	// addEtudiant(new Etudiant("Meriam", LocalDate.parse("2023-09-01"), Niveau.TERMINAL));

//	// 2) Ajouter Cours et Departement en même temps
//	@Override
//	public Course addCoursAndDepart(Course c) {
//		Position dep = c.getPosition();
//		if (dep != null && dep.getIdDepart() == null) {
//			positionRepository.save(dep);
//		}
//		return courseRepository.save(c);
//	}
//
//	// 3) Ajouter Cours et assigner à un Departement existant
//	@Override
//	public Course addCoursAndAssignToDepart(Course c, Long idDepart) {
//		Position dep = positionRepository.findById(idDepart)
//				.orElseThrow(() -> new RuntimeException("Departement not found"));
//		c.setPosition(dep);
//		return courseRepository.save(c);
//	}
//	// 4) Affecter Cours à Etudiant (utiliser findBy pour "keywords")
//	@Override
//	public void affecterCoursToEtudiant(String nomCours, String nomEtudiant) {
//		Course course = courseRepository.findByNomCours(nomCours);
//		Championnat championnat = championnatRepository.findByNomEtudiant(nomEtudiant);
//		if (course != null && championnat != null) {
//			course.getChampionnats().add(championnat);
//			championnat.getCours().add(course);
//			courseRepository.save(course);
//		}
//	}
//	// 5) Lister étudiants avec JPQL
//	public List<Championnat> retrieveEtudiant(Categorie n, LocalDate d, Specialite s) {
//		return championnatRepository.findByNiveauEtudeAndDateInscriAfterAndCoursDepartementSpecialite(n, d, s);
//		// Note : Ajouter cette méthode query dans EtudiantRepository si non auto-générée :
//		// @Query("SELECT e FROM Etudiant e JOIN e.cours c WHERE e.niveauEtude = :n AND e.dateInscri > :d AND c.departement.specialite = :s")
//		// List<Etudiant> findByNiveauEtudeAndDateInscriAfterAndCoursDepartementSpecialite(@Param("n") Niveau n, @Param("d") LocalDate d, @Param("s") Specialite s);
//	}
//	// 6) Scheduler pour ordonner départements par nombre d'affectations
//	@Scheduled(fixedRate = 20000)  // Toutes les 20 secondes
//	public void ordonnerDepart() {
//		// Utiliser JPQL pour compter
//		// Exemple query dans DepartementRepository :
//		// @Query("SELECT d, COUNT(e) FROM Departement d JOIN d.cours c JOIN c.etudiants e GROUP BY d ORDER BY COUNT(e) DESC")
//		// List<Object[]> findDepartementsOrderedByInterest();
//		List<Object[]> results = positionRepository.findDepartementsOrderedByInterest();
//		for (Object[] row : results) {
//			Position d = (Position) row[0];
//			Long count = (Long) row[1];
//			System.out.println("Departement: " + d.getNomDepart() + " - Interests: " + count);
//		}
//	}
//
//	// 7) Désassigner Cours d'Etudiant
//	public void disassignCoursFromEtudiant(String nomCours, String nomEtudiant) {
//		Course course = courseRepository.findByNomCours(nomCours);
//		Championnat championnat = championnatRepository.findByNomEtudiant(nomEtudiant);
//		if (course != null && championnat != null) {
//			course.getChampionnats().remove(championnat);
//			championnat.getCours().remove(course);  // Synchro bidirectionnelle
//			courseRepository.save(course);
//		}
//	}
}