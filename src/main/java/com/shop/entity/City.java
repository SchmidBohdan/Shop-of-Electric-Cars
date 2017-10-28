package com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity

public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@OneToMany(mappedBy = "city", orphanRemoval = true) // , fetch=FetchType.EAGER
	private List<Country> countries = new ArrayList<Country>();

	public City() {

	}


	public City(String name) {
		super();
		this.name = name;
	}



	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + "]";
	}

	

}
