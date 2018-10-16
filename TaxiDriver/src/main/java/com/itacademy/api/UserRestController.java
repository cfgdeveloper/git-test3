package com.itacademy.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.itacademy.application.CustomerController;
import com.itacademy.application.DriverController;
import com.itacademy.application.dto.CustomerDTO;
import com.itacademy.application.dto.DriverDTO;
import com.itacademy.application.dto.UserDTO;
import com.itacademy.utilities.InvalidParamException;
import com.itacademy.utilities.NotFoundException;

@CrossOrigin
@RestController
public class UserRestController {

	@Autowired
	private CustomerController customerController;
	@Autowired
	private DriverController driverController;
	
	
	
	/* customer REST methods */
	
	@GetMapping(value = "/users/customers", produces = "application/json;charset=UTF-8")
	public String listCustomers() throws NotFoundException {
		List<CustomerDTO> customers = customerController.listCustomers();
		return toJson(customers);
	}
	
	@PostMapping(value = "/users/customers", produces = "application/json;charset=UTF-8")
	public String registerCustomer(@RequestBody String jCustomer) throws InvalidParamException, NotFoundException {

		CustomerDTO newCustomer = new Gson().fromJson(jCustomer, CustomerDTO.class);

		CustomerDTO customer = customerController.register(newCustomer);

		return toJson(customer);
	}
	
	
	
	
	/* Driver REST methods */
	
	@GetMapping(value = "/users/drivers", produces = "application/json;charset=UTF-8")
	public String listDrivers() throws NotFoundException {
		List<DriverDTO> drivers = driverController.listDrivers();
		return toJson(drivers);
	}
	
	@PostMapping(value = "/users/drivers", produces = "application/json;charset=UTF-8")
	public String registerDriver(@RequestBody String jDriver) throws InvalidParamException, NotFoundException {

		DriverDTO newDriver = new Gson().fromJson(jDriver, DriverDTO.class);

		DriverDTO driver = driverController.register(newDriver);

		return toJson(driver);
	}
	
	
	
	
	/* common and helper REST methods */
	
	private String toJson(Object object){
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(object);
	}
	
	@GetMapping(value = "/users/", produces = "application/json;charset=UTF-8")
	public String listUsers() throws NotFoundException {
		List<UserDTO> users = new ArrayList<>();
		List<CustomerDTO> customers = customerController.listCustomers();
		//Omplir UserDTO amb customers
		for (CustomerDTO c: customers) {
			UserDTO u = new UserDTO(c.getId(),"customer", c.getName(), c.getEmail(), c.getPassword(),c.getDni(),"");
			users.add(u);
		}
		
		List<DriverDTO> drivers = driverController.listDrivers();
		//Omplir UserDTO amb drivers
		for (DriverDTO d: drivers) {
			UserDTO u = new UserDTO(d.getId(),"driver", d.getName(), d.getEmail(), d.getPassword(),"",d.getDriverId());
			users.add(u);
		}
		
		return toJson(users);
	}
	
	@DeleteMapping(value="/users/")
	public void deleteUsers() {
		customerController.deleteAllCustomers();
		driverController.deleteAllDrivers();
	}
	
}
