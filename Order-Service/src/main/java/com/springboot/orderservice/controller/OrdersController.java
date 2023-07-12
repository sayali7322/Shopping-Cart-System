package com.springboot.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.orderservice.entity.OrderInput;
import com.springboot.orderservice.service.OrderService;

@RestController
public class OrdersController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/placeOrder")
	public void placeOrder(@RequestBody OrderInput orderInput) {
		orderService.placeOrder(orderInput);
	}
}
