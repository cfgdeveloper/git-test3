package com.itacademy.application.dto;

import com.google.gson.annotations.Expose;
import com.itacademy.domain.Driver;
import com.itacademy.utilities.NotFoundException;

public class DriverDTO extends UserDTO {
	@Expose
	private String driverId, email;
	private String password;

	public DriverDTO(Driver driver) throws NotFoundException {
		super(driver);
		this.email = driver.getEmail();
		this.password = driver.getPassword();
		this.driverId = driver.getDriverId();
	}


	public String getDriverId() {
		if(driverId == null) return "";
		return driverId;
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
		return "driver: " + driverId + " / " + email;
	}
}
