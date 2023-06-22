package com.internproj.shopcartsystem.productservice.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import com.internproj.shopcartsystem.productservice.entities.Product;
import com.internproj.shopcartsystem.productservice.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository  productRepository;
	
	public Product viewProductByProdId(int prodId) {	
		Product product = productRepository.findById(prodId).orElse(null);
		//product.setRating(ratingService.viewRatingsByProdId(prodId));
		return product;		
	}
	
	public List<Product> viewProductsByCategory(String category){
		return productRepository.findAllByCategory(category);
	}
	
	public List<Product> viewProductsByProdName(String prodName){
		return productRepository.findAllByProdName(prodName);
	}
	
	public List<Product> addProducts(List<Product> products){
		return productRepository.saveAll(products);
	} 
	
	public Product addProduct(Product product){
		return productRepository.save(product);
	}
	
	public String removeProduct(int prodId) {
		productRepository.deleteById(prodId);
		return "Product Deleted Successfully";
	}

	public List<Product> viewAllProducts() {
		return productRepository.findAll();
	}
		

}
