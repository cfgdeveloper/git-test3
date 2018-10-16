package com.itacademy.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itacademy.application.dto.CustomerDTO;
import com.itacademy.application.dto.DriverDTO;
import com.itacademy.domain.Customer;
import com.itacademy.domain.Driver;
import com.itacademy.persistence.CustomerRepository;
import com.itacademy.persistence.DriverRepository;
import com.itacademy.utilities.InvalidParamException;
import com.itacademy.utilities.NotFoundException;

@Controller
public class DriverController {

	@Autowired
	private DriverRepository driverRepository;
	
	public List<DriverDTO> listDrivers() throws NotFoundException {
		List<Driver> driverList = driverRepository.getAllDrivers();
		List<DriverDTO> driverDTOList = new ArrayList<>();

		if (driverList.isEmpty())
			throw new NotFoundException();

		for (Driver d : driverList) {
			driverDTOList.add(new DriverDTO(d));
		}

		return driverDTOList;
	}

	public DriverDTO register(DriverDTO driverDTO) throws InvalidParamException, NotFoundException {

		Driver driver = new Driver(driverDTO);
		driverRepository.save(driver);

		return new DriverDTO(driver);
	}
	
	Driver getDriver(String driverId) throws NotFoundException {
		Driver driver = driverRepository.getDriverByDriverId(driverId);
		return driver;
	}
	
	public void deleteAllDrivers() {
		driverRepository.deleteAll();
	}
}
