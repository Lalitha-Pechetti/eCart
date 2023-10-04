package com.lalli.eCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lalli.eCart.model.ProductModel;
import com.lalli.eCart.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	@PostMapping("/addProduct")
	private String  addProduct(@RequestBody ProductModel productModel) {
		productService.addProduct(productModel);
		return "product added successfully";
		
	}
	@GetMapping("/getProducts")
	private List<ProductModel> getProducts(){
		return productService.getProducts();
	}
	@GetMapping("/getProduct/{id}")
	private ProductModel getProduct(@PathVariable ("id") int productId) {
		return  productService.getProduct(productId);
		
	}
	@GetMapping("/deleteProduct/{id}")
	private String deleteProduct(@PathVariable ("id") int productId) {
		  productService.deleteProduct(productId);
		  return "product deleted successfully";
	}
	@GetMapping("/searchProduct/{searchParam}")
	private List<ProductModel> searchProduct(@PathVariable ("searchParam") String searchParam){
		 return productService.searchProduct(searchParam);
	}
	@GetMapping("/allProducts")
	private List<ProductModel> allproducts(){
		return productService.allProducts();
	}
	

}
