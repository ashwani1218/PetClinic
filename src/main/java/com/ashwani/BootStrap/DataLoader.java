package com.ashwani.BootStrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ashwani.Model.Owner;
import com.ashwani.Model.Pet;
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
		owner1.setAddress("123 waldhuni");
		owner1.setCity("Kalyan");
		owner1.setTelphone("123456789");
		
		Pet ashwanisPet=new Pet();
		ashwanisPet.setPetType(savedDogPetType);
		ashwanisPet.setName("Doggo");
		ashwanisPet.setBirthDate(LocalDate.now());
		ashwanisPet.setOwner(owner1);
		owner1.getPets().add(ashwanisPet);
		
		ownerService.Save(owner1);
		
		
		Owner owner2=new Owner();
		owner2.setFirstName("Aman");
		owner2.setLastName("Pandey");
		owner2.setAddress("123 waldhuni");
		owner2.setCity("Kalyan");
		owner2.setTelphone("123456788");
		
		Pet amansPet=new Pet();
		amansPet.setName("SomeCat");
		amansPet.setBirthDate(LocalDate.now());
		amansPet.setOwner(owner2);
		amansPet.setPetType(savedCatPetType);
		owner2.getPets().add(amansPet);
		
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
