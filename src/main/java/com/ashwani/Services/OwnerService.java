package com.ashwani.Services;

import com.ashwani.Model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

	Owner findByLastName(String lastName); 
}
