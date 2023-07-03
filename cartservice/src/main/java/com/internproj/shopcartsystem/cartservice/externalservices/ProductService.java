package com.internproj.shopcartsystem.cartservice.externalservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.internproj.shopcartsystem.cartservice.entities.Product;


@FeignClient(name="PRODUCT-SERVICE")
public interface ProductService {
	
	@GetMapping("/product/viewProduct/{productId}")
	public Product viewProduct(@PathVariable int productId);

}
