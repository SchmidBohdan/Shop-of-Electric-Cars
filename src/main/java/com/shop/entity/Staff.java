package com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstname;
	private String lastName;
	private String surName;
	private String email;
	private String address;
	private int age;
	private int phone;
	

	@OneToMany(mappedBy = "manufacturer")
	private List<Product> products = new ArrayList<>();
	
	@ManyToOne
	private Sex sex;
	
	public Staff(){
		
	}
	
	

	public Staff(String firstname, String lastName, String surname, String email, String address, int age, int phone) {
		super();
		this.firstname = firstname;
		this.lastName = lastName;
		this.surName = surname;
		this.email = email;
		this.address = address;
		this.age = age;
		this.phone = phone;
	}


	
	
	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products = products;
	}



	public Sex getSex() {
		return sex;
	}



	public void setSex(Sex sex) {
		this.sex = sex;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Staff{" +
				"id=" + id +
				", firstname='" + firstname + '\'' +
				", lastName='" + lastName + '\'' +
				", surName='" + surName + '\'' +
				", email='" + email + '\'' +
				", address='" + address + '\'' +
				", age=" + age +
				", phone=" + phone +
				", products=" + products +
				", sex=" + sex +
				'}';
	}
}
