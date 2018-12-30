package com.ashwani.Map;

import java.util.Set;
import com.ashwani.Model.Vet;
import com.ashwani.Services.VetService;

public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

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
		// TODO Auto-generated method stub
		return super.Save(object.getId(), object);
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
