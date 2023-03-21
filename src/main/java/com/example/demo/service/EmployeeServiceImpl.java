package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.apiuResponce.ApiResponce;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeServiceIfc {
	private static final Logger LOGGER= LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public ApiResponce addEmployee(EmployeeDto employeeDto) {
		try {

			if (employeeDto != null) {
				Employee employee = new Employee();
				employee.setEmpId(employeeDto.getEmpId());
				employee.setId(employeeDto.getId());
				employee.setFirstName(employeeDto.getFirstName());
				employee.setLastName(employeeDto.getLastName());
				employee.setMobileNo(employeeDto.getMobileNo());
				employee.setEmail(employeeDto.getEmail());
				employeeRepository.save(employee);
				//System.out.println("Employee add the data successfull");
				LOGGER.trace("Employee add the data successfull");
				return new ApiResponce("Employee add data successfull", true, employee);

			} else {
				return new ApiResponce("Employee not add datd successfull", false, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ApiResponce(e.getMessage(), false, null);
		}

	}

	public ApiResponce getAll() {
		List<Employee> employees = employeeRepository.findAll();
	
		return new ApiResponce("Get The all user data successfully", true, employees);
		
	}

	public ApiResponce getById(String id) {
		try {
			Employee employee = employeeRepository.findbyEmployeeId(id);
			if (employee != null) {
				return new ApiResponce("Get by user id succefull", true, employee);
			} else {
				return new ApiResponce("user not defined", false, null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ApiResponce("Id is not deleted", false, null);
		}

	}

	@Override
	public ApiResponce updateEmployee(EmployeeDto employeeDto) {
		try {
			if (employeeDto != null) {

				Employee employee = employeeRepository.findbyEmployeeId(employeeDto.getId());
				if (employee != null) {
					employee.setEmail(employeeDto.getEmail());
					employee.setFirstName(employeeDto.getFirstName());
					employee.setId(employeeDto.getId());
					employee.setLastName(employeeDto.getLastName());
					employee.setMobileNo(employeeDto.getMobileNo());
					employeeRepository.save(employee);
					return new ApiResponce("update employee successfull", true, employee);
				} else {
					return new ApiResponce("employee id is not found", false, null);
				}
			} else {
				return new ApiResponce("employee can't be null or empty", false, null);

			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ApiResponce(e.getMessage(), false, null);

		}
	}

	public ApiResponce delete(String id) {
		try {

			employeeRepository.deleteById(id);
			return new ApiResponce("delete userid Successfully", true, null);

		} catch (Exception e) {
			e.printStackTrace();
			return new ApiResponce("user not deleated", false, null);
		}

	}

}
