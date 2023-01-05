package com.example.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Employee;
import com.example.demo.domain.ResponseDTO;
import com.example.demo.exceptionHandle.BusinessException;
import com.example.demo.exceptionHandle.DataRepositoryException;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private static final Logger LOGGER = LogManager.getLogger(EmployeeServiceImpl.class.getName());
	@Autowired
	private EmployeeRepository employeeRepository;

	public ResponseDTO<String> addEmployee(List<Employee> emp) {
		LOGGER.info("employeeServiceImpl addEmployee() Initiated");

		try {
			if (!emp.isEmpty()) {
				emp.forEach(data -> {
					employeeRepository.save(data);
				});
			}

		} catch (BusinessException be) {
			LOGGER.error(be);
			throw be;
		}catch(DataRepositoryException de) {
			LOGGER.error(de);
			throw new DataRepositoryException();
		}catch (Exception e) {
			LOGGER.error(e);
			throw (e);
		}
		LOGGER.info("employeeServiceImpl addEmployee() Terminated");

		return new ResponseDTO<>(false,HttpStatus.OK.value(),"Employee Added");
	}

	@Override
	public ResponseDTO<List<Employee>> getEmployeeByDep(UUID departmentId) {
		List<Employee> emp= employeeRepository.findByDepId(departmentId);	
		if(emp.isEmpty()) {
			throw new BusinessException("No Employees under this department");
		}
		return new ResponseDTO<List<Employee>>(false,HttpStatus.OK.value(),emp);
		}

}
