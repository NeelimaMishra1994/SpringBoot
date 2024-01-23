package springbootrestcrudemployeewithspringdatajpa.springbootrestcrudemployeewithspringdatajpa.service;

import java.util.List;

import springbootrestcrudemployeewithspringdatajpa.springbootrestcrudemployeewithspringdatajpa.entity.Employee;



public interface EmployeeService {
List<Employee> findAll();
Employee  findById(int id);
Employee save(Employee theEmployee);
void deleteById(int id);
}
