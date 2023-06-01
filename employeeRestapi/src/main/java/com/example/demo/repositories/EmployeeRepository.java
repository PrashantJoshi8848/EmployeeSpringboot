package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.employeesEntities;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<employeesEntities, Integer>{
	
	List<employeesEntities> findByNameAndEmail(String name, String email,Sort sort);

	void deleteById(Integer id);

	employeesEntities save(employeesEntities entities);

	Optional<employeesEntities> findById(Integer id);

}
