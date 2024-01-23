package springbootrestcrudemployeewithspringdatajpa.springbootrestcrudemployeewithspringdatajpa.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootrestcrudemployeewithspringdatajpa.springbootrestcrudemployeewithspringdatajpa.entity.Employee;
import springbootrestcrudemployeewithspringdatajpa.springbootrestcrudemployeewithspringdatajpa.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
private EmployeeService employeeService;
	
	//quick and dirty:inject EmployeeService(use constructor injection)
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
		
	@GetMapping("/employees/{empId}")
	 public Employee  getEmployee(@PathVariable int empId) {
		Employee employee= employeeService.findById(empId);
		if(employee == null) {
			throw new RuntimeException("employee not found");
		}
		return employee;
	}
	
	

	@PostMapping("/employees")
	 public Employee addEmployee(@RequestBody Employee employee ) {
		employee.setId(0);
		Employee dbemployee = employeeService.save(employee);
		return dbemployee; 
	 }
	
	
	
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theemployee) {
		Employee dbemployee = employeeService.save(theemployee);
		return dbemployee; 
	}
	

	
	@DeleteMapping("/employees/{empId}")
	public void deleteEmployeeId(@PathVariable int empId) {
		Employee employee= employeeService.findById(empId);
		if(employee == null) {
			throw new RuntimeException("employee not found");
		}
		employeeService.deleteById(empId);
		
	}

}
