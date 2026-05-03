package tn.esprit.Exam.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Exam.Entity.Departement;
import tn.esprit.Exam.Entity.Etudiant;

import java.util.List;

@Repository
public interface DepartementRepository extends CrudRepository<Departement, Long>{
    Departement findByNomDepart(String nomDepart);

    @Query("SELECT d, COUNT(e) FROM Departement d JOIN Cours c ON c.departement = d JOIN Etudiant e ON e MEMBER OF c.etudiants GROUP BY d ORDER BY COUNT(e) DESC")
    List<Object[]> findDepartementsOrderedByInterest();
}
