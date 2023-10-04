package com.lalli.eCart.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lalli.eCart.entity.ProductEntity;
@Repository
public interface ProductRepository  extends JpaRepository<ProductEntity,Integer>{
@Query(value="select * from products where product_name like %:searchParam% ",nativeQuery=true)
	List<ProductEntity> searchProduct(@Param("searchParam")String searchParam);
//PageRequest  firstPageWithFiveElement=  PageRequest.of(0,5, Sort.by("productName").descending().and (Sort.by("productPrice").ascending()));
//List<ProductEntity> findAll(firstPageWithFiveElement);

}
