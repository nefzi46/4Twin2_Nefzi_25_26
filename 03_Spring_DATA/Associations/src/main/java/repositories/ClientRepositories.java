package repositories;

import Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepositories extends JpaRepository<Client,Long> {

}
