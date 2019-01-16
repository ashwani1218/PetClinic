package com.ashwani.Services.DataJPA;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ashwani.Model.Pet;
import com.ashwani.Repository.PetRepository;
import com.ashwani.Services.PetService;

@Service
@Profile("springdatajpa")
public class PetJpaService implements PetService{

	private final PetRepository petRepository;
	
	
	public PetJpaService(PetRepository petRepository) {
		super();
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
	
		Set<Pet> pets = new HashSet<Pet>();
		
		petRepository.findAll().forEach(pets::add);
		
		return pets;
	}

	@Override
	public Pet findById(Long id) {
		
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet Save(Pet object) {
		return petRepository.save(object);
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}
}
