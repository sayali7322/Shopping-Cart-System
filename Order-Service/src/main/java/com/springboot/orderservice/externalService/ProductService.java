package com.springboot.orderservice.externalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.springboot.orderservice.entity.Product;


@FeignClient(name="product-service", url="http://localhost:8081/")
public interface ProductService {
	
	@GetMapping("/viewProductByProdId/{productId}")
	public Product viewProductByProdId(@PathVariable int productId);
}
