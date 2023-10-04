package com.lalli.eCart.model;

public class WishlistModel {
	private int favouriteItemId;
     private int userId;
	private int productId;
	public int getFavouriteItemId() {
		return favouriteItemId;
	}
	public void setFavouriteItemId(int favouriteItemId) {
		this.favouriteItemId = favouriteItemId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "WishlistModel [favouriteItemId=" + favouriteItemId + ", userId=" + userId + ", productId=" + productId
				+ "]";
	}
	
}
