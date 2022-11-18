package com.kodlamaio.northwind.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {

	private int categoryId;
	private String name;
	private double unitPrice;
	private int unitsInStock;

}
