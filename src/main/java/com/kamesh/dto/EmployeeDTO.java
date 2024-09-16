package com.kamesh.dto;

import java.util.List;
import com.kamesh.entity.Employee;

import lombok.Data;

@Data
public class EmployeeDTO {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private List<String> phoneNumbers;
	private String doj;
	private Double salary;
	public Double taxAmount;
	public Double cessAmount;

	// Convert Entity to DTO to Get Employee
	public static EmployeeDTO valueOf(Employee employee) {

		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployeeId(employee.getEmployeeId());
		employeeDTO.setFirstName(employee.getFirstName());
		employeeDTO.setLastName(employee.getLastName());
		employeeDTO.setEmail(employee.getEmail());
		employeeDTO.setPhoneNumbers(employee.getPhoneNumbers());
		employeeDTO.setDoj(employee.getDoj());
		employeeDTO.setSalary(employee.getSalary());
		return employeeDTO;

	}

	// Convert DTO into Entity to Create Employee
	public Employee createEmployeeEntity() {

		Employee employee = new Employee();
		employee.setEmployeeId(this.getEmployeeId());
		employee.setFirstName(this.getFirstName());
		employee.setLastName(this.getLastName());
		employee.setEmail(this.getEmail());
		employee.setPhoneNumbers(this.getPhoneNumbers());
		employee.setDoj(this.getDoj());
		employee.setSalary(this.getSalary());
		return employee;

	}

	

}
