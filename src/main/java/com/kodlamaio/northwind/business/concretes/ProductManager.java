package com.kodlamaio.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.abstracts.ProductService;
import com.kodlamaio.northwind.business.requests.CreateProductRequest;
import com.kodlamaio.northwind.business.responses.CreateProductResponse;
import com.kodlamaio.northwind.business.responses.GetAllProductsResponse;
import com.kodlamaio.northwind.business.responses.GetProductResponse;
import com.kodlamaio.northwind.dataAccess.abstracts.ProductRepository;
import com.kodlamaio.northwind.entities.Category;
import com.kodlamaio.northwind.entities.Product;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
	private ProductRepository productRepository;

	@Override
	public List<GetAllProductsResponse> getAll() {
		List<Product> products = productRepository.findAll();
		List<GetAllProductsResponse> productsResponse = new ArrayList<GetAllProductsResponse>();

		for (Product product : products) {
			GetAllProductsResponse responseItem = new GetAllProductsResponse();
			responseItem.setId(product.getId());
			responseItem.setName(product.getName());
			responseItem.setUnitPrice(product.getUnitPrice());
			responseItem.setUnitsInStock(product.getUnitsInStock());
			responseItem.setCategoryName(product.getCategory().getName());

			productsResponse.add(responseItem);
		}
		return productsResponse;
	}

	@Override
	public CreateProductResponse add(CreateProductRequest createProductRequest) {
		Product product = new Product();
		
		product.setName(createProductRequest.getName());
		product.setUnitPrice(createProductRequest.getUnitPrice());
		product.setUnitsInStock(createProductRequest.getUnitsInStock());
		
		Category category = new Category();
		category.setId(createProductRequest.getCategoryId());
		product.setCategory(category);
		
		this.productRepository.save(product);
		
		
		CreateProductResponse productResponse = new CreateProductResponse();

		productResponse.setName(createProductRequest.getName());
		productResponse.setUnitPrice(createProductRequest.getUnitPrice());
		productResponse.setUnitsInStock(createProductRequest.getUnitsInStock());
		productResponse.setCategoryId(createProductRequest.getCategoryId());
		productResponse.setId(product.getId());

		return productResponse;
	}

	@Override
	public List<GetAllProductsResponse> getByName(String name) {
		List<Product> products = new ArrayList<Product>();
		List<GetAllProductsResponse> productsResponse = new ArrayList<GetAllProductsResponse>();

		for (Product product : products) {
			if (product.getName() == name) {
				GetAllProductsResponse responseItem = new GetAllProductsResponse();
				responseItem.setId(product.getId());
				responseItem.setName(product.getName());
				responseItem.setUnitPrice(product.getUnitPrice());
				responseItem.setUnitsInStock(product.getUnitsInStock());
				responseItem.setCategoryName(product.getCategory().getName());

				productsResponse.add(responseItem);
			}
		}
		return productsResponse;
	}

	@Override
	public GetProductResponse getById(int id) {
		GetProductResponse productResponse = new GetProductResponse();
		var result = productRepository.findById(id).get();
		productResponse.setId(result.getId());
		productResponse.setName(result.getName());
		productResponse.setUnitPrice(result.getUnitPrice());
		productResponse.setUnitsInStock(result.getUnitsInStock());
		productResponse.setCategoryName(result.getCategory().getName());
		return productResponse;

	}

}
