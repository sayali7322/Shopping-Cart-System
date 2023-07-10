package com.internproj.shopcartsystem.productservice.entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String productName;
	private double price;
	private String category;
	private String description;
	private String productImage;
	private int productQuantity;
	
	   
	public Product() {

	}


	public Product(int productId, String productName, double price, String category, String description,
			String productImage, int productQuantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.category = category;
		this.description = description;
		this.productImage = productImage;
		this.productQuantity = productQuantity;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getProductImage() {
		return productImage;
	}


	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}


	public int getProductQuantity() {
		return productQuantity;
	}


	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	
	
}