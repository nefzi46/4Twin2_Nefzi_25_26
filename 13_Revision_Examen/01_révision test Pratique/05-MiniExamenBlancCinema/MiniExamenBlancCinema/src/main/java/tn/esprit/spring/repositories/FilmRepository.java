package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Film;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {


}
