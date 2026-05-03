package tn.esprit.spring.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Employe;

@Repository
public interface EmployeRepository extends CrudRepository<Employe, Long> {

	@Query("select e from Employe e where e.contrat.dateFin=?1 and e.contrat.type!='CDI'")
	List<Employe> ListerEmploye(Date systemDate);
}
