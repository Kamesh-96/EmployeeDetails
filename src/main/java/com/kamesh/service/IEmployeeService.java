package com.kamesh.service;

import com.kamesh.dto.EmployeeDTO;
import com.kamesh.entity.Employee;
import com.kamesh.exception.EmployeeNotFoundException;

public interface IEmployeeService {

	public EmployeeDTO getEmployeeTaxDeductions(String employeeId) throws EmployeeNotFoundException;

	public Employee createEmployee(EmployeeDTO employeeDTO) throws EmployeeNotFoundException;

}
