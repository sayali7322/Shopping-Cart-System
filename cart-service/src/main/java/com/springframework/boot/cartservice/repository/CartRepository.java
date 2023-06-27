package com.springframework.boot.cartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springframework.boot.cartservice.Entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
