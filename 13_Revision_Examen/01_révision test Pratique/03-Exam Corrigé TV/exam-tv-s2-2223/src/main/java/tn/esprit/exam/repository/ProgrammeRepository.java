package tn.esprit.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.exam.entity.Profession;
import tn.esprit.exam.entity.Programme;
import tn.esprit.exam.entity.Thematique;
import tn.esprit.exam.entity.Utilisateur;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public interface ProgrammeRepository extends JpaRepository<Programme, Long> {


    List<Programme> findAllByPrNom(String prNom);


    /*@Query("SELECT distinct (p) FROM Programme p " +
            "INNER JOIN p.utilisateurs u " +
            "WHERE u.profession = :p ")
    List<Programme> listerProgrammesInteressants(@Param("p") Profession p);*/

}