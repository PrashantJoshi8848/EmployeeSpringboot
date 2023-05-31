package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String PostEmployees(@RequestBody employeesEntities employeesEntities) {
		if(employeeService.addEmployees(employeesEntities))return "succefully added employer";
		return "faild to add user";
	}
	
	@GetMapping("/employee/{id}")
	public String getSingleMapping(@PathVariable("id") Long id) {
		return "display sing list"+ id;
	}
	
	@PutMapping("/employee/{id}")
	public employeesEntities updateEmployee(@PathVariable("id") Long id,@RequestBody employeesEntities employeesEntities) {
		return  employeesEntities;
	}
	
	@DeleteMapping("/employees")
	public String deletedString(@RequestParam("id") Long id) {
		return "Delating the employ id"+ id;
	}

}
