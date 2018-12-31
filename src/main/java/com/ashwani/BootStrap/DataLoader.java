package com.ashwani.BootStrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ashwani.Model.Owner;
import com.ashwani.Model.PetType;
import com.ashwani.Model.Vet;
import com.ashwani.Services.OwnerService;
import com.ashwani.Services.PetTypeService;
import com.ashwani.Services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private OwnerService ownerService;
	private VetService vetService;
	private PetTypeService petTypeService; 
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService,PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService=petTypeService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		PetType dog= new PetType();
		dog.setName("Dog");
		PetType savedDogPetType=petTypeService.Save(dog);
		
		PetType cat= new PetType();
		cat.setName("Cat");
		PetType savedCatPetType=petTypeService.Save(cat);
		
		Owner owner1=new Owner();
		owner1.setFirstName("Ashwani");
		owner1.setLastName("Pandey");
		ownerService.Save(owner1);
		
		Owner owner2=new Owner();
		owner2.setFirstName("Aman");
		owner2.setLastName("Pandey");
		ownerService.Save(owner2);
		
		Vet vet1=new Vet();
		vet1.setFirstName("Khushboo");
		vet1.setLastName("Pandey");
		vetService.Save(vet1);
		
		Vet vet2=new Vet();
		vet2.setFirstName("Pooja");
		vet2.setLastName("Pandey");
		vetService.Save(vet2);
	
		System.out.println("Vets Added..");
	
	}

}
