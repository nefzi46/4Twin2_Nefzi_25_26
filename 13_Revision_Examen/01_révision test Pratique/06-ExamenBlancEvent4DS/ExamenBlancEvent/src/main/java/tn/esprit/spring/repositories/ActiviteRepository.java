package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Activite;

@Repository
public interface ActiviteRepository extends JpaRepository<Activite, Long> {

}
