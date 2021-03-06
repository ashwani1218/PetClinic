package com.ashwani.Services.Map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ashwani.Model.Pet;
import com.ashwani.Services.PetService;

@Service
@Profile({"default","map"})
public class PetMapService extends AbstractMapService<Pet,Long> implements PetService{

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
		return super.Save(object);
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
