package com.ashwani.Services.Map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T,ID> {

	protected Map<ID,T> map= new HashMap<>();
	
	Set<T> findAll(){
		return new HashSet<>(map.values());
	}
	
	T findById(ID id) {
		return map.get(id);
	}
	
	T Save(ID id,T Object) {
		map.put(id, Object);
		return Object;
	}
	
	void deleteById(ID id) {
		map.remove(id);
	}
	
	void delete(T Object) {
		map.entrySet().removeIf(entry->entry.getValue().equals(Object));
	}
}

