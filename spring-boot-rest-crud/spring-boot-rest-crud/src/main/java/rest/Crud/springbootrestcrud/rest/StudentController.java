package rest.Crud.springbootrestcrud.rest;

import java.util.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import rest.Crud.springbootrestcrud.entity.Student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api")
public class StudentController {
	
	private List<Student> theStudents;//intialized a empty list
	//define a postConstruct to load the students data...only once
	
	@PostConstruct
	public void loadData() {//this approach is much better because we only load student data only once
		theStudents=new ArrayList<Student>();
		theStudents.add(new Student("Neelima","Mishra"));
		theStudents.add(new Student("Harish","khangar"));
		theStudents.add(new Student("Tanya","Yannam"));
	}
	
	//define endpoint for "/students" -return a list of students
	@GetMapping("/students")
	public List<Student> getStudent(){
		return theStudents;	
	}
	
	
	//define endpoint for "/students/{studentsId}" -return student at index
	@GetMapping("/students/{studentId}")
	public Student  getStudent(@PathVariable int studentId){
		//check thetudentId against list size
		if(studentId >= theStudents.size() || studentId < 0) {
			throw new StudentNotFoundException("student id is not found:" +studentId);
		}
		return theStudents.get(studentId);	
	}	
}
