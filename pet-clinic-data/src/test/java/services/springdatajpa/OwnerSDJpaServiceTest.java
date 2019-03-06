package services.springdatajpa;

import buider.OwnerBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import petclinic.model.Owner;
import repositories.OwnerRepository;
import repositories.PetRepository;
import repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Tan";

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;


    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = OwnerBuilder.anOwner().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner serhat = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, serhat.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(returnOwner);
        owners.add(OwnerBuilder.anOwner().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(owners);

        assertNotNull(owners);
        assertEquals(2, service.findAll().size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        assertNotNull(service.findById(1L));
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertNull(service.findById(1L));
    }

    @Test
    void save() {
        Owner savedOwner = service.save(OwnerBuilder.anOwner().id(5L).build());

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        assertNotNull(service.save(savedOwner));
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}