package tn.esprit.Exam.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Exam.Entity.Cours;

@Repository
public interface CoursRepository extends CrudRepository<Cours, Long> {
    Cours findByNomCours(String nomCours);
}
