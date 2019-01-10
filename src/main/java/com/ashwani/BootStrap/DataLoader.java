package com.ashwani.BootStrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ashwani.Model.Owner;
import com.ashwani.Model.Pet;
import com.ashwani.Model.PetType;
import com.ashwani.Model.Specialty;
import com.ashwani.Model.Vet;
import com.ashwani.Services.OwnerService;
import com.ashwani.Services.PetTypeService;
import com.ashwani.Services.SpecialtyService;
import com.ashwani.Services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private OwnerService ownerService;
	private VetService vetService;
	private PetTypeService petTypeService; 
	private SpecialtyService specialtyService;
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService,PetTypeService petTypeService,SpecialtyService specialtyService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService=petTypeService;
		this.specialtyService=specialtyService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		int count= petTypeService.findAll().size();
		
		if(count==0) {
			loadData();
		}
		
	}

	private void loadData() {
		PetType dog= new PetType();
		dog.setName("Dog");
		PetType savedDogPetType=petTypeService.Save(dog);
		
		PetType cat= new PetType();
		cat.setName("Cat");
		PetType savedCatPetType=petTypeService.Save(cat);
		
		Specialty radiology = new Specialty();
		radiology.setDescription("Radiologist");
		Specialty savedRadiology=specialtyService.Save(radiology);
		
		Specialty surgery = new Specialty();
		surgery.setDescription("Surgery Specialist");
		Specialty savedSurgery=specialtyService.Save(surgery);
		
		
		Specialty dentistry = new Specialty();
		dentistry.setDescription("Dentist");
		Specialty savedDentistry=specialtyService.Save(dentistry);
		
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
		vet1.getSpecialty().add(savedRadiology);
		vetService.Save(vet1);
		
		Vet vet2=new Vet();
		vet2.setFirstName("Pooja");
		vet2.setLastName("Pandey");
		vet2.getSpecialty().add(savedDentistry);
		vetService.Save(vet2);
		
		Vet vet3=new Vet();
		vet3.setFirstName("Vishal");
		vet3.setLastName("Pandey");
		vet3.getSpecialty().add(savedSurgery);
		vetService.Save(vet3);
		
		System.out.println("Vets Added..");
	
		
	}

}
