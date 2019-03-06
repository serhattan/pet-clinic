package buider;

import petclinic.model.Owner;
import petclinic.model.Pet;

import java.util.HashSet;
import java.util.Set;

public final class OwnerBuilder {
    private String firstName;
    private String lastName;
    private Long id;
    private String address;
    private String city;
    private String telephone;
    private Set<Pet> pets = new HashSet<>();

    private OwnerBuilder() {
    }

    public static OwnerBuilder anOwner() {
        return new OwnerBuilder();
    }

    public OwnerBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public OwnerBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public OwnerBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public OwnerBuilder address(String address) {
        this.address = address;
        return this;
    }

    public OwnerBuilder city(String city) {
        this.city = city;
        return this;
    }

    public OwnerBuilder telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public OwnerBuilder pets(Set<Pet> pets) {
        this.pets = pets;
        return this;
    }

    public Owner build() {
        Owner owner = new Owner();
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        owner.setId(id);
        owner.setAddress(address);
        owner.setCity(city);
        owner.setTelephone(telephone);
        owner.setPets(pets);
        return owner;
    }
}
