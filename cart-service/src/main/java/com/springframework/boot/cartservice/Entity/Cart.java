package com.springframework.boot.cartservice.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Cart")
public class Cart {
	
	private int cartId;
	private String prodName;
	private double price;
	private int quantity;
	private double totalPrice;
	
	public Cart(int cartId, String prodName, double price, int quantity, double totalPrice) {
		super();
		this.cartId = cartId;
		this.prodName = prodName;
		this.price = price;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
