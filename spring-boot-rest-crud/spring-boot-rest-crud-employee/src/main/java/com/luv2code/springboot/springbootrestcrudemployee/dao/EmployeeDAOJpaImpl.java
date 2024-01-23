package com.luv2code.springboot.springbootrestcrudemployee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.springbootrestcrudemployee.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

	//define field for entityManager
	private EntityManager entityManager;
	
	//setup constructor injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	
	@Override
	public List<Employee> findAll() {
		
		//Create a Query
		TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee",Employee.class);
		
		//execute query and get result list
		List<Employee> employees= theQuery.getResultList();
		
		//return the results
		return employees;
	}


	@Override
	public Employee findById(int id) {
		//get the employee
		//return the employee
		Employee emp = entityManager.find(Employee.class,id);
		return emp;
	}


	@Override
	public Employee save(Employee theEmployee) {
		Employee dbEmployee = entityManager.merge(theEmployee);//merge is like if there is no element it will add otherwise it will upadte based on id
		return dbEmployee;//it has updated id from the database(in the case of insert)
	}


	@Override
	public void deleteById(int id) {
		Employee emp = entityManager.find(Employee.class,id);
		entityManager.remove(emp);
		
		
	}
}
//Note: we are not using @transaction annotation in DAO because it does not handel Transactional it will be used in sservice layer
