package tn.esprit.Exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Exam.Entity.Departement;

@Repository
public interface DepartementRepo extends JpaRepository<Departement, Integer> {
	
	
	
	

}
