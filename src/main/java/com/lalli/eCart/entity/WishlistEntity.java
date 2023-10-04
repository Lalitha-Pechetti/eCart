package com.lalli.eCart.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="wish_list")
public class WishlistEntity {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="favourite_item_id")
	private int favouriteItemId;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private UserEntity userEntity;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="productId")
	private ProductEntity productEntity;

	public int getFavouriteItemId() {
		return favouriteItemId;
	}

	public void setFavouriteItemId(int favouriteItemId) {
		this.favouriteItemId = favouriteItemId;
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

	@Override
	public String toString() {
		return "WishlistEntity [favouriteItemId=" + favouriteItemId + ", userEntity=" + userEntity + ", productEntity="
				+ productEntity + "]";
	}
	
	
}
