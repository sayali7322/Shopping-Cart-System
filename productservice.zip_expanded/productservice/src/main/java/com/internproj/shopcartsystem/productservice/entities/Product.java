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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int prodId;
	private String prodName;
	private int price;
	private String category;
	private String specifications;
	
	
	public Product() {

	}

//	public Product(int prodId, String prodName, int price, String category, String specifications) {
//		super();
//		this.prodId = prodId;
//		this.prodName = prodName;
//		this.price = price;
//		this.category = category;
//		this.specifications = specifications;
//	}
	
	public Product(int prodId, String prodName, int price, String category, String specifications) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.price = price;
		this.category = category;
		this.specifications = specifications;
	}


	public int getProdId() {
		return prodId;
	}


	public void setProdId(int prodId) {
		this.prodId = prodId;
	}


	public String getProdName() {
		return prodName;
	}


	public void setProdName(String prodName) {
		this.prodName = prodName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getSpecifications() {
		return specifications;
	}


	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	
}