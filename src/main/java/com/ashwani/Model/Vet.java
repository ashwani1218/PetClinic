package com.ashwani.Model;

import java.util.Set;

public class Vet extends Person {

	private Set<Specialty> specialty;

	public Set<Specialty> getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Set<Specialty> specialty) {
		this.specialty = specialty;
	}
	
}
