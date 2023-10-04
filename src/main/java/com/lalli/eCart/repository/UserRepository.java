package com.lalli.eCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lalli.eCart.entity.UserEntity;
import com.lalli.eCart.entity.UserProductMappingEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
	UserEntity findByEmail(String name);
	@Query(value = "select * from users where USER_ID=:userId",nativeQuery=true)
	UserEntity basedOnUserId(@Param("userId") int userId);
	@Query(value = "select * from users where user_name like %:searchParam% or  email like  %:searchParam%",nativeQuery=true)
	List<UserEntity> searchProduct(@Param("searchParam") String searchParam);
}
