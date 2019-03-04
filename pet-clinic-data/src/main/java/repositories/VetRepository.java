package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
