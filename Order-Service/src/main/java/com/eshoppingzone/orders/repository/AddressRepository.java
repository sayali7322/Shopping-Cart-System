package com.eshoppingzone.orders.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eshoppingzone.orders.model.Address;

@Repository
public interface AddressRepository extends  JpaRepository<Address, Integer> {
	List<Address> findByCustomerId(int customerId);
	List<Address> findByFullName(String fullName);
}