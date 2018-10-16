package com.itacademy.persistence;

import org.springframework.data.repository.CrudRepository;

import com.itacademy.domain.Customer;

public interface HelperCustomerRepository extends CrudRepository<Customer, Integer>{

	public Customer findByEmail(String email);

	public void saveAndFlush(Customer customer);
}
