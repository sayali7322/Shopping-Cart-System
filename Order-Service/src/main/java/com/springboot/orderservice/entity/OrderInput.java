package com.springboot.orderservice.entity;

import java.util.List;

public class OrderInput {
	
	private String fullName;
	private String fullAddress;
	private long phoneNo;
	private long alternatePhoneNo;
	private List<OrderProductQuantity> orderProductQuantityList;
	
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
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
	public List<OrderProductQuantity> getOrderProductQuantityList() {
		return orderProductQuantityList;
	}
	public void setOrderProductQuantityList(List<OrderProductQuantity> orderProductQuantityList) {
		this.orderProductQuantityList = orderProductQuantityList;
	}
	
	
}
