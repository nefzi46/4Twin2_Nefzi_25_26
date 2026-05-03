package tn.esprit.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.entities.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {}

