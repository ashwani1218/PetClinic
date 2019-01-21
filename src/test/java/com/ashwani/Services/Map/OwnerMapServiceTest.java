package com.ashwani.Services.Map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ashwani.Model.Owner;
import com.ashwani.Services.PetService;
import com.ashwani.Services.PetTypeService;

class OwnerMapServiceTest {
	final Long ownerId=1L;
	final Long owner2Id=2L;
	final String lastName="Pandey";
	
	OwnerMapService ownerMapService;
	@Mock
	 PetTypeService petTypeService;
	@Mock
	 PetService petService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		ownerMapService=new OwnerMapService(petTypeService, petService);
		ownerMapService.Save(Owner.builder().id(ownerId).lastName(lastName).build());
	}

	@Test
	void testFindAll() {
		Set<Owner> ownerSet=  ownerMapService.findAll();
		assertEquals(1, ownerSet.size());
	}

	@Test
	void testFindByIdLong() {
		Owner owner=ownerMapService.findById(ownerId);
		assertEquals(ownerId,owner.getId());
	}

	@Test
	void testSaveOwner() {
		Owner savedOwner=Owner.builder().id(owner2Id).build();
		Owner saved=ownerMapService.Save(savedOwner);
		assertEquals(owner2Id, saved.getId());
	}
	
	@Test
	void testNoId() {
		Owner owner=ownerMapService.Save(Owner.builder().build());
		assertNotNull(owner);
		assertNotNull(owner.getId());
	}

	@Test
	void testDeleteOwner() {
		ownerMapService.delete(ownerMapService.findById(ownerId));
		assertEquals(0,ownerMapService.findAll().size());
	}

	@Test
	void testDeleteByIdLong() {
		ownerMapService.deleteById(ownerId);
		assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner pandey = ownerMapService.findByLastName(lastName);
		assertNotNull(pandey);
		assertEquals(ownerId,pandey.getId());
	
	}

}
