package com.ashwani.Services.Map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.ashwani.Model.Owner;
import com.ashwani.Model.Pet;
import com.ashwani.Services.OwnerService;
import com.ashwani.Services.PetService;
import com.ashwani.Services.PetTypeService;

@Service
public class OwnerMapService extends AbstractMapService<Owner,Long> implements OwnerService{

	private PetTypeService petTypeService;
	private PetService petService;
	
	
	public OwnerMapService(PetTypeService petTypeService, PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Set<Owner> findAll(){
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}
	
	@Override
	public Owner Save(Owner object) {
		if(object!=null) {
			if(object.getPets()!=null) {
				object.getPets().forEach(pet->{
					if(pet.getPetType().getId()!=null) {
						pet.setPetType(petTypeService.Save(pet.getPetType()));
					}else {
						throw new RuntimeException("PetType is required");
					}
					if(pet.getId()==null) {
						Pet savedPet= petService.Save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}
			return super.Save(object);
		}
		else {
			return null;
		}
		
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}
	
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
}
