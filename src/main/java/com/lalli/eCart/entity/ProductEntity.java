package com.lalli.eCart.entity;


	
	import java.util.Set;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;

import javax.persistence.Table;

	@Entity
	@Table(name="products")
	public class ProductEntity {
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Id
		@Column(name="productId")
		private int productId;
		@Column(name="productName")
		private String productName;
		@Column (name="productPrice")
		private int productPrice;
		@OneToMany(mappedBy="productEntity")
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
			return "ProductEntity [productId=" + productId + ", productName=" + productName + ", productPrice="
					+ productPrice + ", userProductMappingEntity=" + userProductMappingEntity + "]";
		}
		

	}


