package com.ashwani.Services.DataJPA;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ashwani.Model.Vet;
import com.ashwani.Repository.VetRepository;
import com.ashwani.Services.VetService;

@Service
@Profile("springdatajpa")
public class VetJpaService implements VetService{
	
	private final VetRepository vetRepository;
	
	

	public VetJpaService(VetRepository vetRepository) {
		super();
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets=new HashSet<Vet>();
	
		vetRepository.findAll().forEach(vets::add);
		
		return vets;
	}

	@Override
	public Vet findById(Long id) {
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet Save(Vet object) {
		return vetRepository.save(object);
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}

	
}
