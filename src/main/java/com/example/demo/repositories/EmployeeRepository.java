package com.example.demo.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

	@Query("select e from Employee e where e.departmentId = :departmentId ")
	public List<Employee> findByDepId(UUID departmentId);
	

}
