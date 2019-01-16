package com.ashwani.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ashwani.Model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
