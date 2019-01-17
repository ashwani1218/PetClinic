package com.ashwani.Model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity{

	
	public Person(Long id,String firstName, String lastName) {
		super(id);
		FirstName = firstName;
		LastName = lastName;
	}

	@Column(name="first_name")
	private String FirstName;
	
	@Column(name="last_name")
	private String LastName;
}
