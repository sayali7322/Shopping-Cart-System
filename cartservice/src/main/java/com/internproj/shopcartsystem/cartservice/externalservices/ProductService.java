package com.internproj.shopcartsystem.cartservice.externalservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.internproj.shopcartsystem.cartservice.entities.Product;


@FeignClient(name="product-service", url="http://localhost:8081/")
public interface ProductService {
	
	@GetMapping("/product/viewProductByProdId/{productId}")
	public Product viewProductByProdId(@PathVariable int productId);

}
