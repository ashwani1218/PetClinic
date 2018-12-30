package com.ashwani.Model;

import java.time.LocalDate;

public class Pet extends BaseEntity {

	private PetType petType;
	private Owner owner;
	private LocalDate birthDate;
}
