package com.ashwani.Services.DataJPA;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ashwani.Model.Specialty;
import com.ashwani.Repository.SpecialtyRepository;
import com.ashwani.Services.SpecialtyService;

@Service
@Profile("springdatajpa")
public class SpecialtyJpaService implements SpecialtyService{

	private final SpecialtyRepository specialtyRepository;

	public SpecialtyJpaService(SpecialtyRepository specialtyRepository) {
		super();
		this.specialtyRepository = specialtyRepository;
	}

	@Override
	public Set<Specialty> findAll() {
		Set<Specialty> specialties= new HashSet<Specialty>();
		specialtyRepository.findAll().forEach(specialties::add);
		return specialties;
	}

	@Override
	public Specialty findById(Long id) {
		return specialtyRepository.findById(id).orElse(null);
	}

	@Override
	public Specialty Save(Specialty object) {
		return specialtyRepository.save(object);
	}

	@Override
	public void delete(Specialty object) {
		specialtyRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		specialtyRepository.deleteById(id);
	}
}
