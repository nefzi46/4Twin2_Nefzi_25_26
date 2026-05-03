package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Cinema;

@Repository
public interface CinemaRepository extends CrudRepository<Cinema, Long> {

}
