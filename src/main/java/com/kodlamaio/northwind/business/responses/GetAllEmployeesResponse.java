package com.kodlamaio.northwind.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllEmployeesResponse {
	private int id;
	private String firstName;
	private String lastName;
	private int salary;
}
