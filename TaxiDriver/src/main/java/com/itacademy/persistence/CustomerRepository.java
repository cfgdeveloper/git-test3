package com.itacademy.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itacademy.domain.Customer;
import com.itacademy.utilities.InvalidParamException;
import com.itacademy.utilities.NotFoundException;

@Repository
public class CustomerRepository {

	@Autowired
	HelperCustomerRepository repository;
	
	/* Persists a Customer entity into the BD */
	public void save(Customer customer) throws InvalidParamException {
		if (customer == null)
			throw new InvalidParamException();
		try {
			repository.saveAndFlush(customer);
		} catch (Exception e) {
			throw new InvalidParamException();
		}
	}

	/* Retrieves a Customer entity by its email */
	public Customer getCustomerByEmail(String email) throws InvalidParamException {
		Customer customer = repository.findByEmail(email);
		if (customer == null)
			throw new InvalidParamException();
		return customer;
	}
	
	/* Retrieves all customer entities */
	public List<Customer> getAllCustomers() {
		List<Customer> result = new ArrayList<>();

		for (Customer u : repository.findAll()) {
			result.add(u);
		}

		return result;
	}
	
	/* Retrieves a Customer entity by its id */
	public Customer getCustomerById(int id) throws NotFoundException {

		try {
			return repository.findById(id).get();
		} catch (Exception exception) {
			throw new NotFoundException();
		}
	}
	
	public void deleteAll() {
		repository.deleteAll();
	}
}
