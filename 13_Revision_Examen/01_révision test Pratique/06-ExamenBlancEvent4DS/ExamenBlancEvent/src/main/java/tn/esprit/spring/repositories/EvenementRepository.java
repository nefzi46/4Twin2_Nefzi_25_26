package tn.esprit.spring.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Evenement;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {
	
	List<Evenement> findByDateEvent(Date dateEvent);

}