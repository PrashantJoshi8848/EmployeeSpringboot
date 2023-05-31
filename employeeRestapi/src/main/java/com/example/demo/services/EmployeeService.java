package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.employeesEntities;
import com.example.demo.repositories.EmployeeRepository;
import com.fasterxml.jackson.core.StreamReadConstraints.Builder;

@Service
public class EmployeeService{	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	
	public List<employeesEntities> getallEmployeesEntities() {
		return employeeRepository.findAll();
	}
	public Optional<employeesEntities> getSingleEmploy(Integer id) {
		return employeeRepository.findById(id);
	}
	public boolean addEmployees(employeesEntities employees){
		employeesEntities employee=employeeRepository.save(employees);
		if(employee.getId()>0)return  true;
		return false;
	}
	public boolean deleteEmployees(Integer Id) {
		employeeRepository.deleteById(Id);
		Optional<employeesEntities> dataOptional=employeeRepository.findById(Id);
		if(dataOptional.isEmpty()) return true;
		return false;
	}
	
	public employeesEntities updateEmployees(employeesEntities entities) {
		return employeeRepository.save(entities);
	}
}
