package com.kamesh.entity;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@Column(unique = true)
	@Nonnull
	private String employeeId;
	@Column
	@Nonnull
	private String firstName;
	@Column
	@Nonnull
	private String lastName;
	@Column
	@Nonnull
	private String email;
	@Nonnull
	private List<String> phoneNumbers;
	@Column
	@Nonnull
	private String doj;
	@Column
	@Nonnull
	private Double salary;

}
