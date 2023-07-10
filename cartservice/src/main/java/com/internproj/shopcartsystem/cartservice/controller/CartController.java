package com.internproj.shopcartsystem.cartservice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internproj.shopcartsystem.cartservice.entities.Cart;
import com.internproj.shopcartsystem.cartservice.services.CartService;
@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping("/addToCart")
	public String addToCart(@RequestBody Cart cart) {
		return cartService.addToCart(cart);
	}
	@DeleteMapping("/removeFromCart/{cartId}/{productId}")
	public void deleteFromCart(@PathVariable int cartId,@PathVariable int productId) {
		cartService.deleteFromCart(cartId, productId);
	}
	
	@PutMapping("/changeQuantity/{cartId}/{productId}/{quantity}")
	public void changeQuantity(@PathVariable int cartId,@PathVariable int productId,@PathVariable int quantity) {
		cartService.changeQuantity(cartId, productId,quantity);
	}
	
	@GetMapping("/viewCart")
	public List<Cart> viewCart(){
		return cartService.viewCart();
	}

}
