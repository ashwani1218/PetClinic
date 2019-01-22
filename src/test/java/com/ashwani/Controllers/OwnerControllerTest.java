package com.ashwani.Controllers;

import static org.junit.jupiter.api.Assertions.fail;


import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ashwani.Model.Owner;
import com.ashwani.Services.OwnerService;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	@Mock
	OwnerService ownerService;
	
	@InjectMocks
	OwnerController ownerController;
	
	Set<Owner> owners;
	final Long id=1L,id2=2L,id3=3L;
	final String firstName="Ashwani";
	final String lastName="Pandey";
	
	MockMvc mockMvc;
	
	@BeforeEach
	void setUp() throws Exception {
		owners=new HashSet<Owner>();
		owners.add(Owner.builder().id(id).firstName(firstName).lastName(lastName).build());
		owners.add(Owner.builder().id(id2).firstName(firstName).lastName(lastName).build());
		owners.add(Owner.builder().id(id3).firstName(firstName).lastName(lastName).build());
		mockMvc=MockMvcBuilders
				.standaloneSetup(ownerController)
				.build();
	}


	@Test
	void testListOwners() {
		fail("Not yet implemented");
	}

	@Test
	void testFindOwners() {
		fail("Not yet implemented");
	}

}
