package com.kodlamaio.northwind.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.northwind.business.abstracts.ProductService;
import com.kodlamaio.northwind.business.requests.CreateProductRequest;
import com.kodlamaio.northwind.business.responses.GetAllProductsResponse;
import com.kodlamaio.northwind.business.responses.GetProductResponse;


import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductsController {
	private ProductService productService;

	@GetMapping("/getall")
	public List<GetAllProductsResponse> getAll() {
		return productService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateProductRequest createProductRequest) {
		productService.add(createProductRequest);
	}

	@GetMapping("/getbyname")
	public List<GetAllProductsResponse> getByName(String name) {
		return productService.getByName(name);
	}

	@GetMapping("/getbyid")
	public GetProductResponse getById(int id) {
		return productService.getById(id);
	}
}
