package com.ashwani.Services.DataJPA;


import static org.mockito.ArgumentMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ashwani.Model.Owner;
import com.ashwani.Repository.OwnerRepository;
import com.ashwani.Repository.PetRepository;
import com.ashwani.Repository.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {
	final String firstName="Ashwani";
	final String lastName="Pandey";
	final Long id=1L;
	@Mock
	OwnerRepository ownerRepository;
	
	@Mock
	PetRepository petRepository;
	
	@Mock
	PetTypeRepository petTypeRepository;
	
	@InjectMocks
	OwnerJpaService service;
	
	Owner returnOwner;
	@BeforeEach
	void setUp() throws Exception {
		returnOwner= Owner.builder().id(id).firstName(firstName).lastName(lastName).build();
	}

	
	@Test
	void testFindAll() {
		Set<Owner> ownerReturnSet=new HashSet<Owner>();
		ownerReturnSet.add(Owner.builder().id(1L).build());
		ownerReturnSet.add(Owner.builder().id(2L).build());
		
		when(ownerRepository.findAll()).thenReturn(ownerReturnSet);
		
		Set<Owner> owner=service.findAll();
		
		assertEquals(2, owner.size());
		
	}

	
	
	@Test
	void testFindById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		Owner owner=service.findById(1L);
		assertNotNull(owner);
	}


	@Test
	void testFindByIdNotFound() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
		Owner owner=service.findById(1L);
		assertNull(owner);
	}

	
	@Test
	void testSave() {
		Owner ownerToSave=Owner.builder().id(2L).build();
		when(ownerRepository.save(any())).thenReturn(returnOwner);
		Owner savedOwner=service.Save(ownerToSave);
		assertNotNull(savedOwner);
	}

	@Test
	void testDelete() {
		service.delete(returnOwner);
		verify(ownerRepository,times(1)).delete(returnOwner);
	}

	@Test
	void testDeleteById() {
		service.deleteById(id);;
		verify(ownerRepository).deleteById(anyLong());
	}

	@Test
	void testFindByLastName() {
		when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
		Owner ashwani=ownerRepository.findByLastName(lastName);
		assertEquals(lastName,ashwani.getLastName());
	}

}
