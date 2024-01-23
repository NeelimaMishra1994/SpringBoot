package com.luv2code.springboot.springbootrestcrudemployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.springbootrestcrudemployee.dao.EmployeeDAO;
import com.luv2code.springboot.springbootrestcrudemployee.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO theEmployeeDAO;

	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		super();
		theEmployeeDAO = employeeDAO;
	}



	@Override
	public List<Employee> findAll() {
		return theEmployeeDAO.findAll();
	}



	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return theEmployeeDAO.findById(id);
	}



	@Override
	@Transactional
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		return theEmployeeDAO.save(theEmployee);
	}



	@Override
	@Transactional
	public void deleteById(int id) {
		theEmployeeDAO.deleteById(id);
	}

}
