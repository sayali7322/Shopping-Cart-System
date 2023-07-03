package com.eshoppingzone.orders.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.eshoppingzone.orders.model.Product;

@FeignClient(value = "product-service")
public interface PlacingOrder {
	
	@DeleteMapping("/decreaseQuant/{productId}/{quantity}")
	public Product decreaseItem(@PathVariable int productId,@PathVariable int quantity);
	
}