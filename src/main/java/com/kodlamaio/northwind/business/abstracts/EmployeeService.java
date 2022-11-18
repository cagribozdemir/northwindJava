package com.kodlamaio.northwind.business.abstracts;

import java.util.List;

import com.kodlamaio.northwind.business.requests.CreateEmployeeRequest;
import com.kodlamaio.northwind.business.responses.GetAllEmployeesResponse;
import com.kodlamaio.northwind.entities.Employee;

public interface EmployeeService {
	List<GetAllEmployeesResponse> getAll();
	Employee getById(int id);
	void add(CreateEmployeeRequest createEmployeeRequest);
}
