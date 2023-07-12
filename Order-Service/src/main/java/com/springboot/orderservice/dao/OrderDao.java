package com.springboot.orderservice.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.orderservice.entity.Order;

public interface OrderDao extends CrudRepository<Order, Integer>{

}
