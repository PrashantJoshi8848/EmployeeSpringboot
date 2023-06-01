package com.example.demo.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity< List<employeesEntities>> getEmployees(@RequestParam int pageNumber,@RequestParam int pageSize) {
		
		return  ResponseEntity.status(HttpStatus.OK).body( employeeService.getallEmployeesEntities(pageNumber,pageSize));
	}
	
	@PostMapping("/employees")
	public ResponseEntity< String> PostEmployees(@Valid @RequestBody employeesEntities employeesEntities) {
		if(employeeService.addEmployees(employeesEntities))return  ResponseEntity.status(HttpStatus.CREATED).body( "succefully added employer");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( "faild to add user");
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity< Optional<employeesEntities>> getSingleMapping(@PathVariable("id") Integer id) {			
		return 	ResponseEntity.status(HttpStatus.OK).body(employeeService.getSingleEmploy(id));
		
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<employeesEntities> updateEmployee(@PathVariable("id") Integer id,@RequestBody employeesEntities employeesentities) {
		employeesentities.setId(id);
		return  ResponseEntity.status(HttpStatus.OK).body( employeeService.updateEmployees(employeesentities));
	}
	
	@DeleteMapping("/employees")
	public ResponseEntity< String> deletedString(@RequestParam("id") Integer id) {
		employeeService.deleteEmployees(id);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body( "deleted success");
	}
	
	@GetMapping("employees/find")
	public ResponseEntity< List<employeesEntities>> nameAndemail(@RequestParam String name,@RequestParam String email){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.findbynameandemail(name, email));
	}

}
