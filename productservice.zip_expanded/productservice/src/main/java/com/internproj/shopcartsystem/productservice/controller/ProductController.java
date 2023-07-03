package com.internproj.shopcartsystem.productservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.openfeign.FeignClient;
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
	
	@GetMapping("/viewAllProducts")
	public List<Product> viewAllProducts(){
		return productService.viewAllProducts();
	}
	
	@GetMapping("/viewProductByProdId/{productId}")
	public Product viewProductByProdId(@PathVariable int productId) {
		return productService.viewProductByProdId(productId);
	}

	@GetMapping("/viewProductsByCategory/{category}")
		public List<Product> viewProductsByCategory(@PathVariable String category){
			return productService.viewProductsByCategory(category);
		}
		
	@GetMapping("/viewProductByProdName/{productName}")
		public List<Product> viewProductsByProdName(@PathVariable String productName){
			return productService.viewProductsByProdName(productName);
		}
		
	@PostMapping("/addProducts")
		public List<Product> addProducts(@RequestBody List<Product> products){
			return productService.addProducts(products);
		} 
		
	@PostMapping("/addProduct")
		public Product addProduct(@RequestBody Product product){
			return productService.addProduct(product);
		}
		
	@DeleteMapping("/removeProduct/{productId}")
		public String removeProduct(@PathVariable int productId) {
			productService.removeProduct(productId);
			return "deleted";
		}
}
