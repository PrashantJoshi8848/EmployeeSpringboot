package com.example.demo.services;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.example.demo.entities.employeesEntities;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeService{	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	
	public List<employeesEntities> getallEmployeesEntities(int pageNumber,int pageSize) {
		PageRequest page=PageRequest.of(pageNumber,pageSize,Direction.DESC,"age");
		return employeeRepository.findAll(page).getContent();
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
	
	public List<employeesEntities> findbynameandemail(String name,String email) {
		return employeeRepository.findByNameAndEmail(name,email,org.springframework.data.domain.Sort.by(org.springframework.data.domain.Sort.Direction.DESC,"id"));
	}
}
