package com.ashwani.Model;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person {

	private String address;
	private String city;
	private String telphone;
	private Set<Pet> pets=new HashSet<>();

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}
}
