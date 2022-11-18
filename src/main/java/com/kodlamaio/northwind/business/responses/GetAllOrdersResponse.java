package com.kodlamaio.northwind.business.responses;

import java.time.LocalDateTime;

import com.kodlamaio.northwind.entities.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllOrdersResponse {
	private int id;
	private Employee employee;
	private LocalDateTime Date;
}
