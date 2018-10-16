package com.itacademy.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itacademy.application.dto.CustomerDTO;
import com.itacademy.domain.Customer;
import com.itacademy.persistence.CustomerRepository;
import com.itacademy.persistence.DriverRepository;
import com.itacademy.utilities.InvalidParamException;
import com.itacademy.utilities.NotFoundException;

@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<CustomerDTO> listCustomers() throws NotFoundException {
		List<Customer> customerList = customerRepository.getAllCustomers();
		List<CustomerDTO> customerDTOList = new ArrayList<>();

		if (customerList.isEmpty())
			throw new NotFoundException();

		for (Customer c : customerList) {
			customerDTOList.add(new CustomerDTO(c));
		}

		return customerDTOList;
	}
	
	public CustomerDTO register(CustomerDTO customerDTO) throws InvalidParamException, NotFoundException {

		Customer customer = new Customer(customerDTO);
		customerRepository.save(customer);

		return new CustomerDTO(customer);
	}

	Customer getCustomer(int customerId) throws NotFoundException {
		Customer customer = customerRepository.getCustomerById(customerId);

		return customer;
	}
	
	public void deleteAllCustomers() {
		customerRepository.deleteAll();
	}
}


