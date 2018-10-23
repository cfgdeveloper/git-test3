package com.itacademy.application.dto;

import com.google.gson.annotations.Expose;
import com.itacademy.domain.Customer;
import com.itacademy.domain.Driver;
import com.itacademy.utilities.NotFoundException;

public class UserDTO {

	/*@Expose
	protected int id;
	@Expose
	protected String userType; //Customer or Driver
	@Expose
	protected String name;
	@Expose
	protected String email;
	@Expose
	protected String password;
	@Expose
	protected String dni;
	@Expose
	protected String driverId;
	
	public UserDTO(int id, String userType, String name, String email, String password, String dni, String driverId) {
		this.id=id;
		this.userType = userType;
		this.name = name;
		this.email = email;
		this.password = password;
		this.dni = dni;
		this.driverId = driverId;
	}
	*/
	
	@Expose
	protected int id;
	@Expose
	protected String name;
	
	public int getId() {
		return id;
	}

	public String getName() {
		if(name == null) return "";
		return name;
	}
	
	public UserDTO() {}
	
	public UserDTO(Customer customer) throws NotFoundException {
		if (customer == null)
			throw new NotFoundException();
		this.id=customer.getId();
		this.name = customer.getName();
	}
	
	public UserDTO(Driver driver) throws NotFoundException {
		if (driver == null)
			throw new NotFoundException();
		this.id=driver.getId();
		this.name = driver.getName();
	}
}
