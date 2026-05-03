package tn.esprit.Exam.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.Exam.Entity.Course;
import tn.esprit.Exam.Entity.Pilote;

public interface PiloteRepository extends CrudRepository<Pilote, Long> {
    Course findByIdPilote(String idPilote);

}
