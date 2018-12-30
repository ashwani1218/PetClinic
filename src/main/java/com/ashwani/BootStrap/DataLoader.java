package com.ashwani.BootStrap;

import org.springframework.boot.CommandLineRunner;

import com.ashwani.Map.OwnerServiceMap;
import com.ashwani.Map.VetServiceMap;
import com.ashwani.Model.Owner;
import com.ashwani.Model.Vet;
import com.ashwani.Services.OwnerService;
import com.ashwani.Services.VetService;

public class DataLoader implements CommandLineRunner {

	private OwnerService ownerService;
	private VetService vetService;
	
	public DataLoader() {
		ownerService= new OwnerServiceMap();
		vetService = new VetServiceMap();
	}

	@Override
	public void run(String... args) throws Exception {
	
		Owner owner1=new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Ashwani");
		owner1.setLastName("Pandey");
		ownerService.Save(owner1);
		
		Owner owner2=new Owner();
		owner1.setId(2L);
		owner1.setFirstName("Aman");
		owner1.setLastName("Pandey");
		ownerService.Save(owner2);
		
		Vet vet1=new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Khushboo");
		vet1.setLastName("Pandey");
		vetService.Save(vet1);
		
		Vet vet2=new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Pooja");
		vet2.setLastName("Pandey");
		vetService.Save(vet2);
	
		System.out.println("Vets Added..");
	
	}

}
