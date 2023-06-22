package com.springframework.boot.cartservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springframework.boot.cartservice.Entity.Cart;

public interface CartRepository extends MongoRepository<Cart, Integer> {

}
