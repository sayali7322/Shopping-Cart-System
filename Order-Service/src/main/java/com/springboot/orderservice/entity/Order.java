package com.springboot.orderservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private String userName;
	private String orderAddress;
	private long phoneNo;
	private long alternatePhoneNo;
	private String orderStatus;
	private double orderAmount;
	
	private Product product;
//	@OneToOne
	private User user;
	

	public Order(String userName, String orderAddress, long phoneNo, long alternatePhoneNo, String orderStatus,
			double orderAmount, Product product, User user) {
		super();
		this.userName = userName;
		this.orderAddress = orderAddress;
		this.phoneNo = phoneNo;
		this.alternatePhoneNo = alternatePhoneNo;
		this.orderStatus = orderStatus;
		this.orderAmount = orderAmount;
		this.product = product;
		this.user = user;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getOrderAddress() {
		return orderAddress;
	}


	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}


	public long getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public long getAlternatePhoneNo() {
		return alternatePhoneNo;
	}


	public void setAlternatePhoneNo(long alternatePhoneNo) {
		this.alternatePhoneNo = alternatePhoneNo;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public double getOrderAmount() {
		return orderAmount;
	}


	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
