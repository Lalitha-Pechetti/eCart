package com.lalli.eCart.model;

import java.util.List;

public class UserDetailsResponse {
	private UserDetails userDetails;
	private List<CartItem> cartItems;
	private List<WishlistItem> wistlistItems;
	
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public List<WishlistItem> getWistlistItems() {
		return wistlistItems;
	}
	public void setWistlistItems(List<WishlistItem> wistlistItems) {
		this.wistlistItems = wistlistItems;
	}
	@Override
	public String toString() {
		return "UserDetailsResponse [userDetails=" + userDetails + ", cartItems=" + cartItems + ", wistlistItems="
				+ wistlistItems + "]";
	}
	

}
