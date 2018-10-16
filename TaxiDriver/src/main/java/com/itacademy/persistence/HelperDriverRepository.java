package com.itacademy.persistence;

import org.springframework.data.repository.CrudRepository;

import com.itacademy.domain.Driver;

public interface HelperDriverRepository extends CrudRepository<Driver, Integer>{

	public Driver findByEmail(String email);
	public Driver findByDriverId(String driverId);
	public void saveAndFlush(Driver driver);
}
