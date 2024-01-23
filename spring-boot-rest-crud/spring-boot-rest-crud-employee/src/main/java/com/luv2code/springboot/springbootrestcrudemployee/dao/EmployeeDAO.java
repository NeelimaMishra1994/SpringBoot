package com.luv2code.springboot.springbootrestcrudemployee.dao;

import java.util.List;

import com.luv2code.springboot.springbootrestcrudemployee.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	Employee  findById(int id);
	Employee save(Employee theEmployee);
	void deleteById(int id);
}
