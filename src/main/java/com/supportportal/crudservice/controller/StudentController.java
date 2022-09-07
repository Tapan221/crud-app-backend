package com.supportportal.crudservice.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supportportal.crudservice.model.Student;
import com.supportportal.crudservice.service.StudentService;



@RestController
@RequestMapping("/studentsapi")
public class StudentController {
	@Autowired
	StudentService service;
	
	@PostMapping("/student")
	public Student addStudentToDb(@RequestBody Student student) {
		
		return service.saveStudent(student);
		
	}
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents(){
		return service.getAllStudents();
		
	}
	@GetMapping("/getStudent/{id}")
	public Optional<Student> getASingleStudent(@PathVariable int id) {
		return service.getStudent(id);
		
	}
	@DeleteMapping("/deleteById/{id}")
	public String deleteStudentById(@PathVariable int id) {
		return service.deleteStudent(id);
		
	}

}
