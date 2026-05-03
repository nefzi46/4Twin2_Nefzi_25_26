package tn.esprit.Exam.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.Exam.Entity.Championnat;
import tn.esprit.Exam.Entity.Course;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    Course findByNomCourse(String nomCourse);

    //    @Query("SELECT e FROM Championnat e JOIN e.cours c WHERE e.niveauEtude = :n AND e.dateInscri > :d AND c.departement.specialite = :s")
//    List<Championnat> findByNiveauEtudeAndDateInscriAfterAndCoursDepartementSpecialite(
//            @Param("n") Categorie n,
//            @Param("d") LocalDate d,
//            @Param("s") Specialite s);
//
//    @Query("SELECT e FROM Course e JOIN e.Championnat c WHERE e.emplacement = :n AND e.dateCourse = :d AND c.Championnat   ")
//    List<Championnat> findByNiveauEtudeAndDateInscriAfterAndCoursDepartementSpecialite(
//            @Param("n") emplacement n,
//            @Param("d") dateCourse d,
//            @Param("s") championnat s);
}
