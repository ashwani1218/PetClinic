package com.ashwani.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="owners")
public class Owner extends Person {

	@Builder
	public Owner(Long id, String firstName, String lastName, String address, String city, String telphone,
			Set<Pet> pets) {
		super(id, firstName, lastName);
		this.address = address;
		this.city = city;
		this.telphone = telphone;
		this.pets = pets;
	}

	@Column(name="address")
	private String address;
	
	@Column(name="city")
	private String city;
	
	@Column(name="telephone")
	private String telphone;

	@OneToMany(cascade=CascadeType.ALL,mappedBy="owner")
	private Set<Pet> pets=new HashSet<>();
}
