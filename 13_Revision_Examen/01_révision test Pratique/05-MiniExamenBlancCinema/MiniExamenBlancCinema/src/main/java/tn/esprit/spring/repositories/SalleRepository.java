package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Cinema;
import tn.esprit.spring.entities.Salle;

@Repository
public interface SalleRepository extends CrudRepository<Salle, Long> {
	
	@Query("select s from Salle s where s.cinema=?1")
	List<Salle> ListerSalle (Cinema c);

	// Afficher le nombre de film à diffcuser à une salle passée en paramètre 
	@Query("select count(f) from Salle s join s.films f where s.id=?1 ")
	long NbreFilmAUneSalle(long salleId);
}
