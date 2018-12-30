package com.ashwani.Map;

import java.util.Set;

import com.ashwani.Model.Owner;
import com.ashwani.Services.CrudService;

public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements CrudService<Owner,Long>{

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
		// TODO Auto-generated method stub
		return super.Save(object.getId(), object);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}
	
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}
