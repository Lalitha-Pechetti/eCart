package com.lalli.eCart.model;

import java.util.List;

public class WishlistResponse {
	private int userId;
	private List<WishlistProduct> wishlistProducts;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<WishlistProduct> getWishlistProducts() {
		return wishlistProducts;
	}
	public void setWishlistProducts(List<WishlistProduct> wishlistProducts) {
		this.wishlistProducts = wishlistProducts;
	}
	@Override
	public String toString() {
		return "WishlistResponse [userId=" + userId + ", wishlistProducts=" + wishlistProducts + "]";
	}
	

}
