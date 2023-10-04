package com.lalli.eCart.entity;

import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

	@Entity
	@Table(name="user_product_mapping")
	public class UserProductMappingEntity {
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Id
		@Column(name="cartId")
		private int cartId;
		@JsonIgnore
		@ManyToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="userId")
		private UserEntity userEntity;
		@JsonIgnore
		@ManyToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="productId")
		private ProductEntity productEntity;
		
		@Column(name="quantity")
		private int quantity;

		public int getCartId() {
			return cartId;
		}

		public void setCartId(int cartId) {
			this.cartId = cartId;
		}

		public UserEntity getUserEntity() {
			return userEntity;
		}

		public void setUserEntity(UserEntity userEntity) {
			this.userEntity = userEntity;
		}

		public ProductEntity getProductEntity() {
			return productEntity;
		}

		public void setProductEntity(ProductEntity productEntity) {
			this.productEntity = productEntity;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			return "CartEntity [cartId=" + cartId + ", userEntity=" + userEntity + ", productEntity=" + productEntity
					+ ", quantity=" + quantity + "]";
		}
		
		

	}




