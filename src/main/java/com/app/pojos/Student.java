package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="student_tbl")
public class Student extends BaseEntity {
	
	@Column(name="Fname")
	private String firstName;
	@Column(name="Lname")
	private String lastName;
	@Column(name="Branch")
	private String branch;
	
	@Column(name="Email",unique=true,length=30)
	private String email;
	
	@Column(name="Password")
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;
	
	@OneToMany(mappedBy="student",cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval = true)
	private List<Course> courses=new ArrayList<>();
	
	public void addCourse(Course course) {
		courses.add(course);
		course.setStudent(this);
	}

	public String getFirstName() {
		return firstName;
	}

	

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", branch=" + branch + ", email=" + email
				+ ", password=" + password + "]";
	}
	
}
