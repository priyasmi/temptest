package com.example.demo.service;

import java.util.List;
import java.util.UUID;


import com.example.demo.domain.Employee;
import com.example.demo.domain.ResponseDTO;

public interface EmployeeService {
	public ResponseDTO<String> addEmployee(List<Employee> emp);

	public ResponseDTO<List<Employee>> getEmployeeByDep(UUID departmentId);

}
