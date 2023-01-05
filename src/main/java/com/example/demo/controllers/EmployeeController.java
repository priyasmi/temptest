package com.example.demo.controllers;


import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Employee;
import com.example.demo.domain.ResponseDTO;
import com.example.demo.service.EmployeeService;


@RestController
@RequestMapping("/emp")
public class EmployeeController {
	private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class.getName());

	@Autowired
	private EmployeeService employeeService;
	

	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value ="/addEmp")
	public ResponseEntity<ResponseDTO<String>> addEmp(@RequestBody List<Employee> emp) {
		LOGGER.info("Emp Controller");		
		return new ResponseEntity<>(employeeService.addEmployee(emp), HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value ="/getemp")
	public ResponseEntity<ResponseDTO<List<Employee>>> get(@RequestParam UUID departmentId) {
		LOGGER.info("Emp Controller get by dep");
		 return new ResponseEntity<>(employeeService.getEmployeeByDep(departmentId), HttpStatus.OK);
	}
	
}
