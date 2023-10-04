package com.lalli.eCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lalli.eCart.model.WishlistModel;
import com.lalli.eCart.model.WishlistResponse;
import com.lalli.eCart.service.WishlistService;

@RestController
public class WishlistController {
	@Autowired
	WishlistService wishlistService;
	@PostMapping("/addFavouriteProduct")
	private String addFavouriteProduct(@RequestBody WishlistModel wishlistModel) {
		wishlistService.addFavouriteProduct(wishlistModel);
		return "favourite item added successfully";
	}
	/*@GetMapping("/getFavouriteProduct(s)")
	private List<WishlistResponse> getFavouriteProduct(@RequestParam(required=false) int userId){
		return wishlistService.getFavouriteProduct
	}*/
	
}
