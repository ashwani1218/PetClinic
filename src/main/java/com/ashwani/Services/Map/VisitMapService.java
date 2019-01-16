package com.ashwani.Services.Map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ashwani.Model.Visit;
import com.ashwani.Services.VisitService;

@Service
@Profile({"default","map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

	@Override
	public Set<Visit> findAll() { 
		return super.findAll();
	}

	@Override
	public Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Visit Save(Visit visit) {
		
		if(visit.getPet()==null || visit.getPet().getOwner()==null || visit.getPet().getId()==null
				|| visit.getPet().getOwner().getId()==null) {
			throw new RuntimeException("Invalid Visit");
			
		}
		
		return super.Save(visit);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Visit Object) {
		super.delete(Object);
	}

	
	
}
