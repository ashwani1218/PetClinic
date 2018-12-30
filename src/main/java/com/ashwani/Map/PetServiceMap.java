package com.ashwani.Map;

import java.util.Set;

import com.ashwani.Model.*;
import com.ashwani.Services.CrudService;

public class PetServiceMap extends AbstractMapService<Pet,Long> implements CrudService<Pet,Long>{

	@Override
	public Set<Pet> findAll(){
		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}
	
	@Override
	public Pet Save(Pet object) {
		// TODO Auto-generated method stub
		return super.Save(object.getId(), object);
	}

	@Override
	public void delete(Pet object) {
		super.delete(object);
	}
	
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
	
}
