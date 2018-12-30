package com.ashwani.Services.Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import com.ashwani.Model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {

	protected Map<Long,T> map= new HashMap<>();
	
	Set<T> findAll(){
		return new HashSet<>(map.values());
	}
	
	T findById(ID id) {
		return map.get(id);
	}
	
	T Save(T Object) {
		if(Object!=null) {
			if(Object.getId()==null) {
				Object.setId(getNextId());
			}
			map.put(Object.getId(), Object);
		}
		else 
			throw new RuntimeException("Object cannot be Null");
		
		return Object;
	}
	
	void deleteById(ID id) {
		map.remove(id);
	}
	
	void delete(T Object) {
		map.entrySet().removeIf(entry->entry.getValue().equals(Object));
	}
	
	private long getNextId() {
		Long nextId=null;
		try {
			nextId=Collections.max(map.keySet())+1; 
		}
		catch(NoSuchElementException e) {
			nextId=1L;
		}
		return nextId;
	}

}

