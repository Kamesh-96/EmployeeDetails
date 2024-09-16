package com.kamesh.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamesh.dto.EmployeeDTO;
import com.kamesh.entity.Employee;
import com.kamesh.exception.EmployeeNotFoundException;
import com.kamesh.repository.IEmployeeRepository;
import com.kamesh.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public EmployeeDTO getEmployeeTaxDeductions(String employeeId) throws EmployeeNotFoundException {
		logger.info("Request to get an employee {}", employeeId);
		EmployeeDTO employeeDTO = new EmployeeDTO();
		Optional<Employee> checkEmployee = employeeRepository.findById(employeeId);
		try {
			if (checkEmployee.isPresent()) {
				Employee employee = checkEmployee.get();
				employeeDTO = EmployeeDTO.valueOf(employee);
				employeeDTO. taxAmount = caluculateTaxDeductions(employeeDTO);
				employeeDTO.cessAmount = caluculateCess(employeeDTO);
			}
			logger.info("Employee Details are {}", employeeDTO);
			return employeeDTO;
		} catch (Exception e) {
			// TODO: handle exception
			throw new EmployeeNotFoundException("", e);
		}

	}

	@Override
	public Employee createEmployee(EmployeeDTO employeeDTO) throws EmployeeNotFoundException {
		logger.info("Request to get an employee {}", employeeDTO);
		Employee createEmployee = employeeDTO.createEmployeeEntity();
		logger.info("Employee was Created {}", createEmployee);
		return employeeRepository.save(createEmployee);
	}

	/**
	 * Function that calculates the tax deductions of an Employee.
	 * 
	 * @param employeeDTO
	 * @return
	 */
	private Double caluculateTaxDeductions(EmployeeDTO employeeDTO) {
		double taxAmount = 0;
		double totalIncome = employeeDTO.getSalary() * 12;
		double incomeSlab = 0;

		if (totalIncome <= 250000) {
			taxAmount = 0.0;
		} else if (totalIncome > 250000 && totalIncome <= 500000) {
			incomeSlab = totalIncome - 250000;
			taxAmount = incomeSlab * 0.05;

		} else if (totalIncome > 500000 && totalIncome <= 1000000) {
			incomeSlab = totalIncome - 500000;
			taxAmount = 12500 + (incomeSlab * 0.1);
		} else if (totalIncome > 1000000) {
			incomeSlab = totalIncome - 1000000;
			taxAmount = 25000 + (incomeSlab * 0.2);
		}
		return taxAmount;

	}

	/**
	 * Function that calculates the tax Cess on salary.
	 * 
	 * @param employeeDTO
	 * @return
	 */
	private Double caluculateCess(EmployeeDTO employeeDTO) {
		double cessAmount = 0;
		double yearlySalary = employeeDTO.getSalary() * 12;
		;

		if (yearlySalary >= 2800000) {
			cessAmount = 300000 * 0.02;
		}
		return cessAmount;

	}

}
