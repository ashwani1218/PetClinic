package com.ashwani.Services.DataJPA;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.ashwani.Model.PetType;
import com.ashwani.Repository.PetTypeRepository;
import com.ashwani.Services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeJpaService implements PetTypeService{

	private final PetTypeRepository petTypeRepository;
	
	
	public PetTypeJpaService(PetTypeRepository petTypeRepository) {
		super();
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<PetType>();
		
		petTypeRepository.findAll().forEach(petTypes::add);
		
		return petTypes;
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType Save(PetType object) {
		return petTypeRepository.save(object);
	}

	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}
	

}
