package com.luv2Code.springBoot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.luv2Code.springBoot.thymeleaf.model.Student;

@Controller
public class StudentController {
  
	
	@PostMapping("/showStudentForm")
	public String showForm(Model themodel) {
		Student theStudent = new Student();
		themodel.addAttribute("student", theStudent);
		return "student-form";
	}
	
	@PostMapping("/processStudentForm")
	public String processForm(@ModelAttribute("student") Student thestudent) {
		
		return "student-confirmation";
	}
}
