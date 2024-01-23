package com.luv2code.springboot.springbootrestcrudemployee.service;

import java.util.List;

import com.luv2code.springboot.springbootrestcrudemployee.entity.Employee;

public interface EmployeeService {
List<Employee> findAll();
Employee  findById(int id);
Employee save(Employee theEmployee);
void deleteById(int id);
}
