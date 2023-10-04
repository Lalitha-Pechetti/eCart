package com.lalli.eCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lalli.eCart.entity.WishlistEntity;
@Repository
public interface WishlistRepository extends JpaRepository<WishlistEntity,Integer>{
	
	@Query(value="select * from wish_list where user_id=:userId", nativeQuery =true)

	List<WishlistEntity> basedOnUserId(@Param("userId") int userId);

}
