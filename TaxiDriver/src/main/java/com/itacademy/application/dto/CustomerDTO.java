package com.itacademy.application.dto;

import com.itacademy.domain.Customer;
import com.itacademy.utilities.NotFoundException;
import com.google.gson.annotations.Expose;

public class CustomerDTO extends UserDTO {
	
	@Expose
	private String dni, email;
	private String password;

	public CustomerDTO(Customer customer) throws NotFoundException {
		super(customer);
		this.email = customer.getEmail();
		this.name = customer.getName();
		this.password = customer.getPassword();
	}


	public String getDni() {
		if(dni == null) return "";
		return dni;
	}

	public String getEmail() {
		if(email == null) return "";
		return email;
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
