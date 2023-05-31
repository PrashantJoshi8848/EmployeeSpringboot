package com.example.demo.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.employeesEntities;
import com.example.demo.services.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<employeesEntities> getEmployees() {
		
		return employeeService.getallEmployeesEntities();
	}
	
	@PostMapping("/employees")
	public String PostEmployees(@Valid @RequestBody employeesEntities employeesEntities) {
		if(employeeService.addEmployees(employeesEntities))return "succefully added employer";
		return "faild to add user";
	}
	
	@GetMapping("/employees/{id}")
	public Optional<employeesEntities> getSingleMapping(@PathVariable("id") Integer id) {			
		return 	employeeService.getSingleEmploy(id);
		
	}
	
	@PutMapping("/employees/{id}")
	public employeesEntities updateEmployee(@PathVariable("id") Integer id,@RequestBody employeesEntities employeesentities) {
		employeesentities.setId(id);
		return  employeeService.updateEmployees(employeesentities);
	}
	
	@DeleteMapping("/employees")
	public String deletedString(@RequestParam("id") Integer id) {
		if(employeeService.deleteEmployees(id))return "delete Succesfully";
				return "user Not found";
	}

}
