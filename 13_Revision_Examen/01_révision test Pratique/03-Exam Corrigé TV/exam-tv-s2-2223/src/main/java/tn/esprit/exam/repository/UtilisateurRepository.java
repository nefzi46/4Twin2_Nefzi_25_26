package tn.esprit.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.exam.entity.Profession;
import tn.esprit.exam.entity.Thematique;
import tn.esprit.exam.entity.Utilisateur;

import java.util.Date;
import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    List<Utilisateur> findAllByUsrNom(String usrNom);

    @Query("SELECT distinct (u) FROM Utilisateur u " +
            "INNER JOIN u.programmes p " +
            "WHERE u.profession=:p " +
            "AND u.usrDateInscription >= :d " +
            "AND p.chaine.chTheme = :t")
    List<Utilisateur> listerUtilisateurs(@Param("p") Profession p, @Param("d") Date d, @Param("t") Thematique t);

}