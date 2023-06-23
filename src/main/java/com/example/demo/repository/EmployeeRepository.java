package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.example.demo.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

//@Query(value = "db.employee_details.find({_id:?}",nativeQuery =true));
	// @Query("{'id':{$regx:?0}}")
	@Query("{id:?0}")
	Employee findByEmployeeId(String id);

	Employee findByFirstName(String firstName);

	// @Query(value = "SELECT * FROM employee_details WHERE first_name =
	// :firstName", exists = true)// SQl Query
	// @Query(value = "{'firstName':?0}", exists = true)

//	 @Query(value = "db.employee_details.find({ firstName: ?0 })", exists = true)
//	// @Query(value = "{ 'firstName' : { $eq : ?0 } }", exists = true)
//	    Employee findByFirstName(String firstName) ;

//	@Query(value = "{ 'firstName' : ?0 }")

	// Employee findByFirstName(String name);

}
