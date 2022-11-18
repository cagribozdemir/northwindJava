package com.kodlamaio.northwind.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.northwind.business.abstracts.OrderService;
import com.kodlamaio.northwind.business.requests.CreateOrderRequest;
import com.kodlamaio.northwind.business.responses.GetAllOrdersResponse;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
	private OrderService orderService;
	
	@Autowired
	public OrdersController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping("/getall")
	public List<GetAllOrdersResponse> getAll() {
		return orderService.getAll();
	}
	
	@PostMapping("/add")
	public void add(CreateOrderRequest createOrderRequest) {
		this.orderService.add(createOrderRequest);
	}
	
	
}
