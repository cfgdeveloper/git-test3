package com.itacademy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

import com.itacademy.application.dto.CustomerDTO;
import com.itacademy.utilities.Encryptor;
import com.itacademy.utilities.InvalidParamException;

@Entity(name="Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id")
	private int id;
	private String name;
	private String email;
	private String password;
	private String dni;
	
	
	
	public Customer() {
	}
	
	public Customer(CustomerDTO c) throws InvalidParamException {
		this.setName(c.getName());
		this.setEmail(c.getEmail());
		this.password = Encryptor.encryptPassword(c.getPassword());
		this.setDni(c.getDni());
	}
	
	private void checkValidDni(String dni) throws InvalidParamException {
		if (dni.isEmpty() || dni.length() != 9)
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
	 
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
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
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) throws InvalidParamException {
		checkValidDni(dni);
		this.dni = dni;
	}
	
}
