package com.kodlamaio.northwind.business.abstracts;

import java.util.List;

import com.kodlamaio.northwind.business.requests.CreateOrderRequest;
import com.kodlamaio.northwind.business.responses.GetAllOrdersResponse;

public interface OrderService {
	List<GetAllOrdersResponse> getAll();
	void add(CreateOrderRequest createOrderRequest);
}
