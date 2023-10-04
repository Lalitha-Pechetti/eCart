package com.lalli.eCart.model;

import java.util.List;



public class UserCartResponse {
	private int userId;
	private List<Product> products;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products= products;
	}
	
	@Override
	public String toString() {
		return "UserCartResponse [userId=" + userId + ", products=" + products + "]";
	}
	
	

}

