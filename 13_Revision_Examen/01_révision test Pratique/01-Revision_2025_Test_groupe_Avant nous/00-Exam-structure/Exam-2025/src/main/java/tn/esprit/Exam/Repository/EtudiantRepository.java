package tn.esprit.Exam.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.Exam.Entity.Departement;
import tn.esprit.Exam.Entity.Etudiant;
import tn.esprit.Exam.Entity.Niveau;
import tn.esprit.Exam.Entity.Specialite;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant, Long>{
    Etudiant findByNomEtudiant(String nomEtudiant);

    @Query("SELECT e FROM Etudiant e JOIN e.cours c WHERE e.niveauEtude = :n AND e.dateInscri > :d AND c.departement.specialite = :s")
    List<Etudiant> findByNiveauEtudeAndDateInscriAfterAndCoursDepartementSpecialite(
            @Param("n") Niveau n,
            @Param("d") LocalDate d,
            @Param("s") Specialite s);
}
