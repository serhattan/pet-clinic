package services;

import petclinic.model.Pet;

import java.util.Set;

public interface PetService extends CrudService<Pet, Long> {

    Pet findByLastName(String lastName);

}
