package com.ashwani.Services.DataJPA;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ashwani.Model.Visit;
import com.ashwani.Repository.VisitRepository;
import com.ashwani.Services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitJpaService implements VisitService {

	private final VisitRepository visitRepository;

	public VisitJpaService(VisitRepository visitRepository) {
		super();
		this.visitRepository = visitRepository;
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits=new HashSet<Visit>();
		visitRepository.findAll().forEach(visits::add);
		return visits;
	}

	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Visit Save(Visit object) {
		return visitRepository.save(object);
	}

	@Override
	public void delete(Visit object) {
		visitRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}
	
	
}
