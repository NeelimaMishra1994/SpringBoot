package com.luv2code.springboot.springbootrestcrudemployee.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.luv2code.springboot.springbootrestcrudemployee.entity.Employee;
import com.luv2code.springboot.springbootrestcrudemployee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	//quick and dirty:inject EmployeeService(use constructor injection)
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	//expose "/employee" and return a list of employee
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	//read a single employee by id so for this
	//add mapping for GET employee/employee id
	//by defualt path variable must be the same
	
	
	@GetMapping("/employees/{empId}")
	 public Employee  getEmployee(@PathVariable int empId) {
		Employee employee= employeeService.findById(empId);
		if(employee == null) {
			throw new RuntimeException("employee not found");
		}
		return employee;
	}
	
	
	//add mapping for post -add new employee
	@PostMapping("/employees")
	 public Employee addEmployee(@RequestBody Employee employee ) {
		//also just in case if they pass an id in json ...set id to 0
		//this is to force a save new iteam....instead of update
		employee.setId(0);
		Employee dbemployee = employeeService.save(employee);
		return dbemployee; 
	 }
	
	
	
	//add mapping for put/employees - update the existing employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theemployee) {
		Employee dbemployee = employeeService.save(theemployee);
		return dbemployee; 
	}
	
	//add mapping for delete/employees delete the 
	
	@DeleteMapping("/employees/{empId}")
	public void deleteEmployeeId(@PathVariable int empId) {
		Employee employee= employeeService.findById(empId);
		if(employee == null) {
			throw new RuntimeException("employee not found");
		}
		employeeService.deleteById(empId);
		
	}
}