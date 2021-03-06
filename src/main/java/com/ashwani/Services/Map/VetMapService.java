package com.ashwani.Services.Map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ashwani.Model.Specialty;
import com.ashwani.Model.Vet;
import com.ashwani.Services.SpecialtyService;
import com.ashwani.Services.VetService;

@Service
@Profile({"default","map"})
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {

	private SpecialtyService specialtyService;
	
	public VetMapService(SpecialtyService specialtyService) {
		super();
		this.specialtyService = specialtyService;
	}

	@Override
	public Set<Vet> findAll(){
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}
	
	@Override
	public Vet Save(Vet object) {
		if(object.getSpecialty().size()>0) {
			object.getSpecialty().forEach(specialty->{
				if(specialty.getId()==null) {
					Specialty savedSpecialty= specialtyService.Save(specialty);
					specialty.setId(savedSpecialty.getId());
					
				}
			});
		}
		return super.Save(object);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}
	
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}
