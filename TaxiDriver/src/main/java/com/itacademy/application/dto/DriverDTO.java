package com.itacademy.application.dto;

import com.google.gson.annotations.Expose;
import com.itacademy.domain.Driver;
import com.itacademy.utilities.NotFoundException;

public class DriverDTO {
	@Expose
	private int id;
	@Expose
	private String name, driverId, email;
	private String password;

	public DriverDTO(Driver driver) throws NotFoundException {
		if (driver == null)
			throw new NotFoundException();
		this.email = driver.getEmail();
		this.name = driver.getName();
		this.password = driver.getPassword();
		this.driverId = driver.getDriverId();
		this.id = driver.getId();
	}

	public int getId() {
		return id;
	}

	public String getDriverId() {
		if(driverId == null) return "";
		return driverId;
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
		return "driver: " + driverId + " / " + email;
	}
}
