package com.example.demo.entities;

import java.sql.Date;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "EmployeeDetails")
public class employeesEntities {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@jakarta.validation.constraints.NotBlank
	@jakarta.validation.constraints.NotNull(message = "name is required")
	private String name;
	
	private Long age=0L;
	
	private String location;
	
	@jakarta.validation.constraints.NotNull(message = "email is required")
	@jakarta.validation.constraints.Email(message = "required valid email")
	private String email;
	
	private String department;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;

	@CreationTimestamp
	@Column(name = "updated_at", nullable = false, updatable = false)
	private Date updatedAt;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
