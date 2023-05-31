package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.employeesEntities;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeService{	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	
	public List<employeesEntities> getallEmployeesEntities() {
		return employeeRepository.findAll();
	}
	public boolean addEmployees(employeesEntities employees){
		employeesEntities employee=employeeRepository.save(employees);
		if(employee.getId()>0)return  true;
		return false;
	}
}
