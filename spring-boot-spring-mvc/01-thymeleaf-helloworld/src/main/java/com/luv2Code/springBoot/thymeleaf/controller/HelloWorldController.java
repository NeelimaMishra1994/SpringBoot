package com.luv2Code.springBoot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "HelloWorld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String letShoutDude(HttpServletRequest request,Model model) {
		String theName= request.getParameter("StudentsName");
		theName = theName.toUpperCase();
		String result = "Yo!" +theName;
		model.addAttribute("message", result);
		return "helloworld";
	}
	
	
	//Now I will use @RequestParam instead of HttpservletRequest, it will bind the data automatically present in method
	
	@GetMapping("/processFormVersionThree")
   public String letShoutDude(@RequestParam("StudentsName") String theName, Model model) {
		theName = theName.toUpperCase();
		String result = "Hello My friend from version 3!" +theName;
		model.addAttribute("message", result); 
		return "helloworld";  
   }
	@PostMapping("/processStudentForm")
	  public String studentForm() {
		return "helloworld";  
	  }

}
