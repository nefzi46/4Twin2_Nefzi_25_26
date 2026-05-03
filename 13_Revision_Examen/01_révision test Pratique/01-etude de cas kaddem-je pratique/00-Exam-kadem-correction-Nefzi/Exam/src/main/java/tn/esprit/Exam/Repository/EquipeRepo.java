package tn.esprit.Exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Exam.Entity.Equipe;
import tn.esprit.Exam.Entity.Etudiant;
@Repository
public interface EquipeRepo extends JpaRepository<Equipe, Integer> {
	
	

}
