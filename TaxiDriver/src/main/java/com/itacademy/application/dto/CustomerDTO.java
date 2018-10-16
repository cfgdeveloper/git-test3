package com.itacademy.application.dto;

import com.itacademy.domain.Customer;
import com.itacademy.utilities.NotFoundException;
import com.google.gson.annotations.Expose;

public class CustomerDTO {
	
	@Expose
	private int id;
	@Expose
	private String name, dni, email;
	private String password;

	public CustomerDTO(Customer customer) throws NotFoundException {
		if (customer == null)
			throw new NotFoundException();

		this.dni = customer.getDni();
		this.email = customer.getEmail();
		this.name = customer.getName();
		this.password = customer.getPassword();
		this.id = customer.getId();
	}

	public int getId() {
		return id;
	}

	public String getDni() {
		if(dni == null) return "";
		return dni;
	}

	public String getEmail() {
		if(email == null) return "";
		return email;
	}

	public String getName() {
		if(name == null) return "";
		return name;
	}
	
	public String getPassword() {
		if(password == null) return "";
		return password;
	}

	@Override
	public String toString() {
		return "customer: " + dni + " / " + email;
	}
}
