package com.kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.northwind.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
