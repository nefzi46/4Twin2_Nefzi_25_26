package tn.esprit.Exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Exam.Entity.Etudiant;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant, Integer> {

}
