package com.lalli.eCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lalli.eCart.entity.UserEntity;
import com.lalli.eCart.model.UserCartResponse;
import com.lalli.eCart.model.UserModel;
import com.lalli.eCart.model.UserProductMappingModel;
import com.lalli.eCart.service.CartService;

@RestController
public class CartController {
	@Autowired
	CartService cartService;
	
	@PostMapping("/addItem")
	private String add(@RequestBody UserProductMappingModel userProductMappingModel){
		return cartService.add(userProductMappingModel);
		}
	@GetMapping("/getItems/{userId}")
	private UserCartResponse getItemsByuserId(@PathVariable("userId") int userId ) {
		return  cartService.getItemsByuserId(userId);
		}
	@GetMapping("/getCount/{id}")
	private long productsCount(@PathVariable("id") int userId){
		return cartService.productsCount(userId);
	}
	
	@GetMapping("/userDetails/{id}")
	private UserEntity gerUserDetails(@PathVariable("id") int userId) {
		return cartService.getUserDetails(userId);
	}
	@DeleteMapping("/deleteProduct")
	private String deleteProduct(@RequestParam int userId,@RequestParam int productId ) {
		cartService.deleteProduct(userId,productId);
		return "product deleted";
	}
	@DeleteMapping("/deleteAllProducts/{userId}")
	private String deleteAllProducts(@PathVariable ("userId") int userId) {
		cartService.delateAllProducts(userId);
		return "all products deleted successfully";
	}
}
