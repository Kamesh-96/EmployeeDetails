package com.kamesh.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kamesh.constants.StatusResponse;
import com.kamesh.dto.EmployeeDTO;
import com.kamesh.entity.Employee;
import com.kamesh.exception.EmployeeNotFoundException;
import com.kamesh.service.IEmployeeService;

@RestController("/api")
public class EmployeeAPIController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IEmployeeService employeeService;

	@GetMapping("/employee/{employeeId}/tax-deductions")
	public ResponseEntity<?> getEmployeeTaxDeductions(@PathVariable String employeeId) {
		logger.info("In getEmployeeTaxDeductions function {}");
		EmployeeDTO employeeDTO = new EmployeeDTO();
		Map<String, Object> employeeMap = new LinkedHashMap<String, Object>();
		try {
			employeeDTO = employeeService.getEmployeeTaxDeductions(employeeId);
			if (employeeDTO != null) {
				employeeMap = StatusResponse.getObjectStatus(employeeDTO);
				logger.info("Result of getEmployeeTaxDeductions function: ", employeeMap);
				return new ResponseEntity<>(employeeMap, HttpStatus.OK);
			} else {
				employeeMap = StatusResponse.noDataFound();
				return new ResponseEntity<>(employeeMap, HttpStatus.NOT_FOUND);
			}
		} catch (EmployeeNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.info("Exception in getEmployeeTaxDeductions function{}");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/employees")
	public ResponseEntity<?> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		logger.info("In createEmployee function {}");
		Employee createEmployee = new Employee();
		Map<String, Object> employeeMap = new LinkedHashMap<String, Object>();
		try {
			createEmployee = employeeService.createEmployee(employeeDTO);
			employeeMap = StatusResponse.createObjectStatus(createEmployee.getEmployeeId());
			logger.info("Result of getEmployeeById function: ", employeeMap);
			return new ResponseEntity<>(employeeMap, HttpStatus.CREATED);
		} catch (EmployeeNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.info("Exception in createEmployee function{}");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


}
