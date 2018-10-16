package com.itacademy.application.dto;

import com.google.gson.annotations.Expose;

public class UserDTO {

	@Expose
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
}
