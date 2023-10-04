package com.lalli.eCart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lalli.eCart.entity.ProductEntity;
import com.lalli.eCart.entity.UserEntity;
import com.lalli.eCart.entity.WishlistEntity;
import com.lalli.eCart.model.WishlistModel;
import com.lalli.eCart.repository.ProductRepository;
import com.lalli.eCart.repository.UserRepository;
import com.lalli.eCart.repository.WishlistRepository;
@Service
public class WishlistService {
@Autowired
WishlistRepository wishlistRepository;
@Autowired
UserRepository userRepository;
@Autowired 
ProductRepository productRepository;

	public void addFavouriteProduct(WishlistModel wishlistModel) {
		WishlistEntity wishlistEntity=new WishlistEntity();
		UserEntity userEntity=userRepository.findById(wishlistModel.getUserId()).get();
		ProductEntity productEntity= productRepository.findById(wishlistModel.getProductId()).get();
		//wishlistEntity.setFavouriteItemId(wishlistModel.getFavouriteItemId());
		wishlistEntity.setUserEntity(userEntity);
		wishlistEntity.setProductEntity(productEntity);
		
		wishlistRepository.save(wishlistEntity);
		
	}

}
