package com.internproj.shopcartsystem.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internproj.shopcartsystem.productservice.entities.Product;
import com.internproj.shopcartsystem.productservice.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/viewProductByProdId/{prodId}")
	public Product viewProductByProdId(@PathVariable int prodId) {
		return productService.viewProductByProdId(prodId);
	}

	@GetMapping("/viewProductsByCategory/{category}")
		public List<Product> viewProductsByCategory(@PathVariable String category){
			return productService.viewProductsByCategory(category);
		}
		
	@GetMapping("/viewProductByProdName/{prodName}")
		public List<Product> viewProductsByProdName(@PathVariable String prodName){
			return productService.viewProductsByProdName(prodName);
		}
		
	@PostMapping("/addProducts")
		public List<Product> addProducts(@RequestBody List<Product> products){
			return productService.addProducts(products);
		} 
		
	@PostMapping("/addProduct")
		public Product addProduct(@RequestBody Product product){
			return productService.addProduct(product);
		}
		
	@DeleteMapping("/removeProduct/{prodId}")
		public String removeProduct(@PathVariable int prodId) {
			productService.removeProduct(prodId);
			return "deleted";
		}
}
