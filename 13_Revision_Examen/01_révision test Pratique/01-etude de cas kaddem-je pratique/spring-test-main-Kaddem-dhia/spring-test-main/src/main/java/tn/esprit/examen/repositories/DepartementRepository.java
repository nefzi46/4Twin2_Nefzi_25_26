package tn.esprit.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
}
