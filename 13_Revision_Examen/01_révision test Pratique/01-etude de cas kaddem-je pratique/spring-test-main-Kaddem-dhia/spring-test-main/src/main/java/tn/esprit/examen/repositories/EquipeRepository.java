package tn.esprit.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Integer> {}

