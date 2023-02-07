package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="course_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Course extends BaseEntity {
	private String name;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	
}
