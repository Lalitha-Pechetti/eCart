package com.lalli.eCart.model;

public class WishlistProduct {
	private String productName;
	private int productPrice;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "WishlistProduct [productName=" + productName + ", productPrice=" + productPrice + "]";
	}

}
