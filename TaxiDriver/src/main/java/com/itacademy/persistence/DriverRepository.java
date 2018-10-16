package com.itacademy.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itacademy.domain.Driver;
import com.itacademy.utilities.InvalidParamException;
import com.itacademy.utilities.NotFoundException;

@Repository
public class DriverRepository {

	@Autowired
	private HelperDriverRepository repository;
	
	/* Persists a Driver entity into the BD */
	public void save(Driver driver) throws InvalidParamException {
		if (driver == null)
			throw new InvalidParamException();
		try {
			repository.saveAndFlush(driver);
		} catch (Exception e) {
			throw new InvalidParamException();
		}
	}

	/* Retrieves a Driver entity by its email */
	public Driver getDriverByEmail(String email) throws InvalidParamException {
		Driver driver = repository.findByEmail(email);
		if (driver == null)
			throw new InvalidParamException();
		return driver;
	}
	
	/* Retrieves all Driver entities */
	public List<Driver> getAllDrivers() {
		List<Driver> result = new ArrayList<>();

		for (Driver u : repository.findAll()) {
			result.add(u);
		}

		return result;
	}
	
	/* Retrieves a Driver entity by its driverId */
	public Driver getDriverByDriverId(String driverId) throws NotFoundException {

		try {
			return repository.findByDriverId(driverId);
		} catch (Exception exception) {
			throw new NotFoundException();
		}
	}
	
	public void deleteAll() {
		repository.deleteAll();
	}

}
