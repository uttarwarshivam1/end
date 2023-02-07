package com.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StudentAdd;
import com.app.dto.StudentUpdateDto;
import com.app.pojos.Student;
import com.app.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService userService;
	
	@Autowired
	private ModelMapper mapper;

	@PostMapping("/add")
	public Student addStudent(@RequestBody StudentAdd studentdto) {
		
		Student student=mapper.map(studentdto,Student.class);
		return userService.addStudent(student);
		
	}
	
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable Integer id) {
		return userService.getStudentById(id);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@RequestBody StudentUpdateDto student) {
		Student studentUpdate=mapper.map(student, Student.class);
		return userService.updateStudent(studentUpdate);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Integer id) {
		 userService.deleteStudentById(id);
	}
}
