package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Usine;

@Repository
public interface UsineRepository extends CrudRepository<Usine, Long> {

}
