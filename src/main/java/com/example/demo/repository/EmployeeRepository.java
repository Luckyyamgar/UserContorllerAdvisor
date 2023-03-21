package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
//@Query(value = "db.employee_details.find({_id:?}",nativeQuery =true));
	//@Query("{'id':{$regx:?0}}")
	@Query("{id:?0}")
	Employee findbyEmployeeId(String id);


}
