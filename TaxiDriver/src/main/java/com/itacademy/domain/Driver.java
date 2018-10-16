package com.itacademy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

import com.itacademy.application.dto.DriverDTO;
import com.itacademy.utilities.Encryptor;
import com.itacademy.utilities.InvalidParamException;

@Entity(name="Driver")
public class Driver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id")
	private int id;
	private String name;
	private String email;
	private String password;
	@Column(name="driver_id")
	private String driverId;
	
	public Driver() {
	}
	
	public Driver(DriverDTO d) throws InvalidParamException {
		this.setName(d.getName());
		this.setEmail(d.getEmail());
		this.password = Encryptor.encryptPassword(d.getPassword());
		this.setDriverId(d.getDriverId());
	}
	
	
	private void checkValidDriverId(String driverId) throws InvalidParamException {
		if (driverId.isEmpty() || driverId.length() != 12)
			throw new InvalidParamException();
	}
	
	private void checkValidEmail(String email) throws InvalidParamException {
		if (email.equals("") || !email.contains(".com") || !email.contains("@"))
			throw new InvalidParamException();
	}
	
	public void checkValidPassword(String password) throws InvalidParamException {
		 if (password.isEmpty())
		 throw new InvalidParamException();
	}
	
	public void checkValidName(String name) throws InvalidParamException {
		 if (name.isEmpty())
		 throw new InvalidParamException();
	}
	
	public void checkPasswordIsCorrect(String password) throws InvalidParamException {
		Encryptor.checkIfPasswordMatches(password, this.password);
	}
	
	/* Getters and Setters */
	
	public String getName() {
		return name;
	}
	 
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws InvalidParamException {
		checkValidEmail(email);
		this.email = email;
	}

	public void setName(String name) throws InvalidParamException {
		checkValidName(name);
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws InvalidParamException {
		checkValidPassword(password);
		this.password = password;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) throws InvalidParamException {
		checkValidDriverId(driverId);
		this.driverId = driverId;
	}
	
	public int getId() {
		return id;
	}

}
