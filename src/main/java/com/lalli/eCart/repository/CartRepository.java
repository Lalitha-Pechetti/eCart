package com.lalli.eCart.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lalli.eCart.entity.UserEntity;
import com.lalli.eCart.entity.UserProductMappingEntity;
@Transactional
@Repository
public interface CartRepository extends JpaRepository<UserProductMappingEntity ,Integer>{
		@Query(value = "select * from user_product_mapping where USER_ID=:userId",nativeQuery=true)
	List<UserProductMappingEntity> basedOnUserId(@Param("userId") int userId);
		@Query(value = "select count(PRODUCT_ID) from user_product_mapping ",nativeQuery=true)
		Long productcountBasedOnId();
		@Modifying
		@Query(value = "delete from user_product_mapping where USER_ID=:userId and PRODUCT_ID=:productId",nativeQuery=true)
		void deleteproductBasedOnId(@Param("userId")int userId,@Param("productId") int productId);
		
		@Modifying
		@Query(value= "delete from user_product_mapping where USER_ID=:userId and PRODUCT_Id=:productId",nativeQuery=true)
		void delateAllProducts(@Param("userId")int userId,@Param("productId") int  productId);
	

}
