package com.lalli.eCart.model;

import java.util.Set;


import com.lalli.eCart.entity.UserProductMappingEntity;

public class ProductModel {
	private int productId;
	
	private String productName;
	
	private int productPrice;
	
	private Set<UserProductMappingEntity >userProductMappingEntity ;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

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

	public Set<UserProductMappingEntity> getUserProductMappingEntity() {
		return userProductMappingEntity;
	}

	public void setUserProductMappingEntity(Set<UserProductMappingEntity> userProductMappingEntity) {
		this.userProductMappingEntity = userProductMappingEntity;
	}

	@Override
	public String toString() {
		return "ProductModel [productId=" + productId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", userProductMappingEntity=" + userProductMappingEntity + "]";
	}
	
}
