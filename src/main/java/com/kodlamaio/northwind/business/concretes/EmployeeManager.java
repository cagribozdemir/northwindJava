package com.kodlamaio.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.abstracts.EmployeeService;
import com.kodlamaio.northwind.business.requests.CreateEmployeeRequest;
import com.kodlamaio.northwind.business.responses.GetAllEmployeesResponse;
import com.kodlamaio.northwind.dataAccess.abstracts.EmployeeRepository;
import com.kodlamaio.northwind.entities.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeManager(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<GetAllEmployeesResponse> getAll() {
		List<Employee> employees = employeeRepository.findAll();
		List<GetAllEmployeesResponse> employeesResponse = new ArrayList<GetAllEmployeesResponse>();
		
		for (Employee employee : employees) {
			GetAllEmployeesResponse responseItem = new GetAllEmployeesResponse();
			responseItem.setFirstName(employee.getFirstName());
			responseItem.setLastName(employee.getLastName());
			responseItem.setSalary(employee.getSalary());
			
			employeesResponse.add(responseItem);
		}
		return employeesResponse;
	}

	@Override
	public void add(CreateEmployeeRequest createEmployeeRequest) {
		Employee employee = new Employee();
		employee.setFirstName(createEmployeeRequest.getFirstName());
		employee.setLastName(createEmployeeRequest.getLastName());
		employee.setSalary(createEmployeeRequest.getSalary());
		
		this.employeeRepository.save(employee);
		
	}

	@Override
	public Employee getById(int id) {
		return employeeRepository.findById(id).get();
	}

}
