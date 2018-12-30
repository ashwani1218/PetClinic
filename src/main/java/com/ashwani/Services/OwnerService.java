package com.ashwani.Services;

import com.ashwani.Model.*;

public interface OwnerService extends CrudService<Owner,Long>{

	Owner findByLastName(String lastName); 
}
