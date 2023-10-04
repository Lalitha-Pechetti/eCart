package com.lalli.eCart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lalli.eCart.entity.ProductEntity;
import com.lalli.eCart.model.ProductModel;
import com.lalli.eCart.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public void addProduct(ProductModel productModel) {
		ProductEntity productEntity= new ProductEntity();
		//productEntity.setProductId(productModel.getProductId());
		productEntity.setProductName(productModel.getProductName());
		productEntity.setProductPrice(productModel.getProductPrice());
		productRepository.save( productEntity);
		
	}

	public List<ProductModel> getProducts() {
		
		List<ProductEntity> products= productRepository.findAll();
		List<ProductModel> productsList= new ArrayList<>();
		for(ProductEntity pe :products ) {
			ProductModel productModel= new ProductModel();
			productModel.setProductId(pe.getProductId());
			productModel.setProductName(pe.getProductName());
			productModel.setProductPrice(pe.getProductPrice());
			
			productsList.add(productModel);
		}
		
		return productsList;
	}

	public ProductModel getProduct(int productId) {
		ProductEntity products= productRepository.findById(productId).get();
		ProductModel productModel= new ProductModel();
		productModel.setProductId(products.getProductId());
		productModel.setProductName(products.getProductName());
		productModel.setProductPrice(products.getProductPrice());
		return productModel;
	}

	public void deleteProduct(int productId) {
		
		productRepository.deleteById(productId);
	}

	public List<ProductModel> searchProduct(String searchParam) {
		List<ProductEntity> products= productRepository.searchProduct(searchParam);
		List<ProductModel> productsList= new ArrayList<>();
		for(ProductEntity pe :products ) {
			ProductModel productModel= new ProductModel();
			productModel.setProductId(pe.getProductId());
			productModel.setProductName(pe.getProductName());
			productModel.setProductPrice(pe.getProductPrice());
			
			productsList.add(productModel);
		}
		
		return productsList;
		
	}
	public List<ProductModel> allProducts(){
		PageRequest  firstPageWithFiveElement=  PageRequest.of(0,5, Sort.by("productName").descending().and (Sort.by("productPrice").ascending()));
		Page<ProductEntity> allProducts = productRepository.findAll(firstPageWithFiveElement);
		List<ProductModel> productsList= new ArrayList<>();
		for(ProductEntity pe :allProducts ) {
			ProductModel productModel= new ProductModel();
			productModel.setProductId(pe.getProductId());
			productModel.setProductName(pe.getProductName());
			productModel.setProductPrice(pe.getProductPrice());
			
			productsList.add(productModel);
		}
		
		return productsList;
		
		
	}

}
