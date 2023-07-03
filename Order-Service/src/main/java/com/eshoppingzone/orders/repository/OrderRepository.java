package com.eshoppingzone.orders.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eshoppingzone.orders.model.Orders;



@Repository
public interface OrderRepository  extends JpaRepository<Orders, Integer>{
	List<Orders> findByCustomerId(Integer customerId);
	List<Orders> findByFullName(String fullName);

	Orders findFirstByOrderByOrderIdDesc();
}