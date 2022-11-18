package com.kodlamaio.northwind.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.northwind.business.abstracts.EmployeeService;
import com.kodlamaio.northwind.business.abstracts.OrderService;
import com.kodlamaio.northwind.business.requests.CreateOrderRequest;
import com.kodlamaio.northwind.business.responses.GetAllOrdersResponse;
import com.kodlamaio.northwind.dataAccess.abstracts.OrderRepository;
import com.kodlamaio.northwind.entities.Order;

@Service
public class OrderManager implements OrderService{
	private OrderRepository orderRepository;
	private EmployeeService employeeService;
	
	@Autowired
	public OrderManager(OrderRepository orderRepository,EmployeeService employeeService) {
		this.orderRepository = orderRepository;
		this.employeeService = employeeService;
	}

	@Override
	public List<GetAllOrdersResponse> getAll() {
		List<Order> orders = orderRepository.findAll();
		List<GetAllOrdersResponse> ordersResponse = new ArrayList<GetAllOrdersResponse>();
		
		for (Order order : orders) {
			GetAllOrdersResponse responseItem = new GetAllOrdersResponse();
			responseItem.setId(order.getId());
			responseItem.setDate(order.getDate());
			responseItem.setEmployee(order.getEmployee());
			
			ordersResponse.add(responseItem);
		}
		return ordersResponse;
	}

	@Override
	public void add(CreateOrderRequest createOrderRequest) {
		Order order = new Order();
		var result = employeeService.getById(createOrderRequest.getEmployeeId());
		order.setEmployee(result);
		this.orderRepository.save(order);
		
	}
	
	
}
