package com.app.service;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResponseException;
import com.app.pojos.Student;
import com.app.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostConstruct
	public void init(){
		System.out.println("in init "+mapper);
	}
	

	@Override
	public Student addStudent(Student student) {
		
		
		
		return studentRepo.save(student);
	}


	@Override
	public Student getStudentById(Integer id) {
		
		
		
		return studentRepo.findById(id).orElseThrow(()->new ResponseException("Invalid Id"));
	}


	@Override
	public Student updateStudent(Student student) {
		
		if( studentRepo.existsById(student.getId()))
		{
//				Student stud=studentRepo.save(student);
				return studentRepo.save(student);
		}
		throw new ResponseException("student does not exist");
	}


	@Override
	public void deleteStudentById(Integer id) {
	 
			studentRepo.deleteById(id);
		
	}

	
	
	
}
