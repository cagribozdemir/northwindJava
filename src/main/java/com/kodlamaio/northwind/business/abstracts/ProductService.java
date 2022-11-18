package com.kodlamaio.northwind.business.abstracts;

import java.util.List;

import com.kodlamaio.northwind.business.requests.CreateProductRequest;
import com.kodlamaio.northwind.business.responses.CreateProductResponse;
import com.kodlamaio.northwind.business.responses.GetAllProductsResponse;
import com.kodlamaio.northwind.business.responses.GetProductResponse;

public interface ProductService {
	List<GetAllProductsResponse> getAll();
	CreateProductResponse add(CreateProductRequest createProductRequest);
	List<GetAllProductsResponse> getByName(String name);
	GetProductResponse getById(int id);
	
}
