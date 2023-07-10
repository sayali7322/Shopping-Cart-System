package com.internproj.shopcartsystem.cartservice.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.internproj.shopcartsystem.cartservice.entities.Cart;
import com.internproj.shopcartsystem.cartservice.entities.Product;
import com.internproj.shopcartsystem.cartservice.exception.CartNotFoundException;
import com.internproj.shopcartsystem.cartservice.externalservices.ProductService;
import com.internproj.shopcartsystem.cartservice.repositories.CartRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ProductService prodService;
	
//	@Transactional
    public String addToCart(Cart cart) {
        Product product = prodService. viewProductByProdId(cart.getProductId());
        
        if (product != null) {
           
            Cart existingCart = cartRepository.findByUserEmail(cart.getUserEmail());

            if (existingCart != null) {
                
//                existingCart.setProductName(product.getProductName());
//                existingCart.setPrice(product.getPrice());
//                existingCart.setQuantity(existingCart.getQuantity() + 1); // Increment quantity by 1
//                existingCart.setProductImage(product.getProductImage());
            	
            	cartRepository.save(cart);

                // Calculate the total amount
                double totalAmount = existingCart.getTotalAmount() + product.getPrice();
                existingCart.setTotalAmount(totalAmount);
            } else {
                // Create a new cart
                cart.setProductName(product.getProductName());
                cart.setPrice(product.getPrice());
                cart.setQuantity(1); // Assuming default quantity is 1
                cart.setProductImage(product.getProductImage());
                cart.setTotalAmount(product.getPrice());

                // Save the new cart in the cart repository
                cartRepository.save(cart);
            }

            return "Added to cart";
        } else {
            throw new CartNotFoundException("Invalid product ID or profile ID");
        }
    }

    
//    @Transactional
    public void deleteFromCart(int cartId, int productId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart != null && cart.getProductId() == productId) {
            cartRepository.deleteById(cartId);
        } else {
            throw new CartNotFoundException("Cart item not found for cart ID: " + cartId + " and product ID: " + productId);
        }
    }

//    @Transactional
    public void changeQuantity(int cartId, int productId, int quantity) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart != null && cart.getProductId() == productId) {
            double unitPrice = cart.getPrice();
            double totalAmount = unitPrice * quantity;

            cart.setQuantity(quantity);
            cart.setTotalAmount(totalAmount);
        } else {
            throw new CartNotFoundException("Cart item not found for cart ID: " + cartId + " and product ID: " + productId);
        }
    }

//    @Transactional(readOnly = true)
    public List<Cart> viewCart() {
        return cartRepository.findAll();
    }
}

	
//	//removeFromCart
//	public void deleteFromCart(int cartId) {
//		cartRepository.deleteById(cartId);
//	}
	
	//changeQuantity
//	public void changeQuantity(int cartId, int quantity) {
//		Cart cart = cartRepository.findById(cartId).orElse(null);
//		cart.setQuantity(quantity);
//	}
//	
//	public List<Cart> viewCart(){
//		return cartRepository.findAll();
//	}
//	
	

