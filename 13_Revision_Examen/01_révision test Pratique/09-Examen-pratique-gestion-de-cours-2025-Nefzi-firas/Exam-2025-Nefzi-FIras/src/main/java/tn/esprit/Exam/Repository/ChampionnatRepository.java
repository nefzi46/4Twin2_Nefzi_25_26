package tn.esprit.Exam.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.Exam.Entity.Championnat;
import tn.esprit.Exam.Entity.Categorie;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ChampionnatRepository extends CrudRepository<Championnat, Long>{
    Championnat findBylibelleC(String libelleC);

//    @Query("SELECT e FROM Championnat e JOIN e.cours c WHERE e.niveauEtude = :n AND e.dateInscri > :d AND c.departement.specialite = :s")
//    List<Championnat> findByNiveauEtudeAndDateInscriAfterAndCoursDepartementSpecialite(
//            @Param("n") Categorie n,
//            @Param("d") LocalDate d,
//            @Param("s") Specialite s);
//
//    @Query("SELECT e FROM Championnat e JOIN e.courses c WHERE e.")
//    List<Championnat> findByNiveauEtudeAndDateInscriAfterAndCoursDepartementSpecialite(
//            @Param("n") libelleC n,
//            @Param("d") Categorie d,
//            @Param("s") annee s);
}
