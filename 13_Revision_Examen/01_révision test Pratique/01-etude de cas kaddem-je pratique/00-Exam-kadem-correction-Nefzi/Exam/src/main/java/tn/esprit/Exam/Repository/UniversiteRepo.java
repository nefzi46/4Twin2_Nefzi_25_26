package tn.esprit.Exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Exam.Entity.Departement;
import tn.esprit.Exam.Entity.Universite;

@Repository
public interface UniversiteRepo extends JpaRepository<Universite, Integer> {
	
	
	
	

}
