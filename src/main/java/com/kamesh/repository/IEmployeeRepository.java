package com.kamesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kamesh.entity.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String>{

}
