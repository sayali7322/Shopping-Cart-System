package com.eshoppingzone.orders.model;

import java.util.List;
import java.util.Objects;
import org.springframework.data.annotation.Transient;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor

public class Cart {

	private int cartId;
	
	private double totalPrice;


	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	

	

	public Cart(int cartId, double totalPrice) {
		super();
		this.cartId = cartId;
		this.totalPrice = totalPrice;
		
	}
		
	public Cart() {
		
	}
	
}