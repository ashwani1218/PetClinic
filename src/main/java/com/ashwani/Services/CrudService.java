package com.ashwani.Services;

import java.util.Set;

public interface CrudService<T,ID> {
	
	Set<T> findAll();
	
	T findById(ID id);
	
	T Save(T object);
	
	void delete(T object);
	
	void deleteById(ID id);

}
