package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.apiuResponce.ApiResponce;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeServiceIfc;
import com.example.demo.service.EmployeeServiceImpl;

import jakarta.validation.Valid;

@Validated
@RestController
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired

	EmployeeServiceIfc employeeServiceIfc;
	@Autowired
	EmployeeServiceImpl employeeserviceImpl;

//Add the data
	@PostMapping("/api/addemployee")
	public ApiResponce Addemployeedetails(@Valid @RequestBody EmployeeDto employeeDto) {
		System.out.println("Update Employee Successfull");
		LOGGER.trace("Add Employee Data Successful");
		return employeeServiceIfc.addEmployee(employeeDto);
	}

//Get by id
	@GetMapping("/api/get/{id}")
	public ApiResponce getById(@PathVariable("id") String id) {
		LOGGER.trace("Get  Employee id Successful ");
		return employeeServiceIfc.getById(id);
	}

//Get all data 
	@GetMapping("/api/getall")
	public ApiResponce getAllEmployee() {
		// System.out.println("Get Employee Data Successful successfully");
		LOGGER.trace("Get  Employee Data Successful ");
		return employeeServiceIfc.getAll();

	}

//Update Employee Method

	@PutMapping("/api/udateempolyee")
	public ApiResponce updateEmployee(@RequestBody EmployeeDto employeeDto) {
		return employeeServiceIfc.updateEmployee(employeeDto);

	}

// delete operation
	@DeleteMapping("/api/deletbyid/{id}")
	public ApiResponce delete(@PathVariable("id") String id) {
		return employeeServiceIfc.delete(id);
	}

}
