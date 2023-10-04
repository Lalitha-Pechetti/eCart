package com.lalli.eCart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lalli.eCart.entity.ProductEntity;
import com.lalli.eCart.entity.UserEntity;
import com.lalli.eCart.entity.UserProductMappingEntity;
import com.lalli.eCart.model.Product;
import com.lalli.eCart.model.UserCartResponse;

import com.lalli.eCart.model.UserProductMappingModel;
import com.lalli.eCart.repository.CartRepository;
import com.lalli.eCart.repository.ProductRepository;
import com.lalli.eCart.repository.UserRepository;

@Service
public class CartService {
	@Autowired
	CartRepository cartRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired 
	ProductRepository productRepository;
	public String add(UserProductMappingModel userProductMappingModel) {
		//UserEntity ue= new UserEntity();
		UserEntity uI=userRepository.findById( userProductMappingModel.getUserId()).get();
		//ProductEntity pe= new ProductEntity();
		ProductEntity pI=productRepository.findById(userProductMappingModel.getProductId()).get();
		UserProductMappingEntity  me= new UserProductMappingEntity ();
		
		//me.setCartId(cartId);
		me.setUserEntity(uI);
		me.setProductEntity(pI);
		me.setQuantity(userProductMappingModel.getQuantity());
		cartRepository.save(me);
		return "added to cart successfully";
	}
	public UserCartResponse  getItemsByuserId(int userId) {
		//UserEntity ue= new UserEntity();
		List<UserProductMappingEntity> upi= cartRepository. basedOnUserId(userId);
		UserCartResponse cr= new UserCartResponse();
		cr.setUserId(userId);
		List<Product> productList= new ArrayList<>();
		for(UserProductMappingEntity up: upi) {
			Product product=new Product();
			product.setProductName(up.getProductEntity().getProductName());
			product.setProductPrice(up.getProductEntity().getProductPrice());
			product.setQuantity(up.getQuantity());
			
			 productList.add(product);	
			}
		cr.setProducts( productList);
		return cr;
		}
	/*public long productsCount(int userId) {
		List<UserProductMappingEntity> upi= cartRepository. basedOnUserId(userId);
		
			List<Product> productList= new ArrayList<>();
			for(UserProductMappingEntity upm: upi) {
				Product product=new Product();
				product.setProductName(upm.getProductEntity().getProductName());
				product.setProductPrice(upm.getProductEntity().getProductPrice());
				product.setQuantity(upm.getQuantity());
				
				 productList.add(product);	
				}
			return productList.size();
		}*/
	public long productsCount(int userId) {
		List<UserProductMappingEntity> upi= cartRepository. basedOnUserId(userId);
		Long count=0L;
		for(UserProductMappingEntity upm: upi) {
			count= cartRepository.productcountBasedOnId();
		}
		return count;
	}
	public UserEntity getUserDetails(int userId) {
		 UserEntity upi= userRepository. basedOnUserId(userId);
		 return upi;
	}
	public  void deleteProduct(int userId,int productId) {
		//List<UserProductMappingEntity> upi= cartRepository. basedOnUserId(userId);
		//for(UserProductMappingEntity upm: upi) {
			cartRepository.deleteproductBasedOnId(userId,productId);
		//}
		
	}
	public void delateAllProducts(int userId) {
		List<UserProductMappingEntity> upi= cartRepository. basedOnUserId(userId);
		for(UserProductMappingEntity upm: upi) {
			cartRepository.delateAllProducts(upm.getUserEntity().getUserId(),upm.getProductEntity().getProductId());
		
	}
	}
}


