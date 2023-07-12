package com.springboot.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.orderservice.dao.OrderDao;
import com.springboot.orderservice.entity.OrderInput;
import com.springboot.orderservice.entity.OrderProductQuantity;
import com.springboot.orderservice.entity.Product;
import com.springboot.orderservice.externalService.ProductService;
import com.springboot.orderservice.externalService.UserService;

@Service
public class OrderService {
	
	private static final String ORDER_PLACED = "Placed";
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	public void placeOrder(OrderInput orderInput) {
		List<OrderProductQuantity> productQuantityList = orderInput.getOrderProductQuantityList();
		
		for(OrderProductQuantity opq : productQuantityList) {
			Product product =  productService.viewProductByProdId(opq.getProductId());
			
//			Order order = new Order(
//					orderInput.getFullName(), orderInput.getFullAddress(), orderInput.getPhoneNo(),
//					orderInput.getAlternatePhoneNo(), ORDER_PLACED, orderAmount:100.09,product 
//					);
		}
	}
}
