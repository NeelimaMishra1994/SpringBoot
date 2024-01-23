package springbootrestcrudspringdatajparestemployeeremovedallboilerplatecode.springbootrestcrudspringdatajparestemployeeremovedallboilerplatecode.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import springbootrestcrudspringdatajparestemployeeremovedallboilerplatecode.springbootrestcrudspringdatajparestemployeeremovedallboilerplatecode.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//that's it no need to write any code LOL.....!
}
