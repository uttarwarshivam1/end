package com.app.service;

import com.app.pojos.Student;

public interface StudentService {
	
	Student addStudent(Student student);
	Student getStudentById(Integer id);
	Student updateStudent(Student student);
	void deleteStudentById(Integer id);
}
