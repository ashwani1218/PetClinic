package com.ashwani.Services.DataJPA;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ashwani.Model.Owner;
import com.ashwani.Repository.OwnerRepository;
import com.ashwani.Repository.PetRepository;
import com.ashwani.Repository.PetTypeRepository;
import com.ashwani.Services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerJpaService implements OwnerService{
	
	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;
	

	public OwnerJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
			PetTypeRepository petTypeRepository) {
		super();
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	
	
	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners=new HashSet<Owner>();
		
		ownerRepository.findAll().forEach(owners::add);
		
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner Save(Owner object) {
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
		
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

}
