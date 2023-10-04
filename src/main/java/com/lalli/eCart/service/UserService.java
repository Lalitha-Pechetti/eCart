package com.lalli.eCart.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.lalli.eCart.entity.UserEntity;
import com.lalli.eCart.entity.UserProductMappingEntity;
import com.lalli.eCart.entity.WishlistEntity;
import com.lalli.eCart.exception.ApplicationErrorException;
import com.lalli.eCart.exception.CheckedException;
import com.lalli.eCart.exception.EmailAlreadyExistsException;
import com.lalli.eCart.exception.UserDoesNotExistException;
import com.lalli.eCart.model.CartItem;
import com.lalli.eCart.model.UserDetails;
import com.lalli.eCart.model.UserDetailsResponse;
import com.lalli.eCart.model.UserModel;
import com.lalli.eCart.model.WishlistItem;
import com.lalli.eCart.repository.CartRepository;
import com.lalli.eCart.repository.ProductRepository;
import com.lalli.eCart.repository.UserRepository;
import com.lalli.eCart.repository.WishlistRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired 
	CartRepository cartRepository;
	@Autowired
	WishlistRepository wishlistRepository;
	public void addUser(UserModel userModel) throws EmailAlreadyExistsException {
		log.info("UserService | addUser | Start>>");
		
		UserEntity userEntity1=userRepository.findByEmail(userModel.getEmail());
		if(userEntity1==null) {
			UserEntity userEntity= new UserEntity();
			//userEntity.setUserId(userModel.getUserId());
			userEntity.setUserName(userModel.getUserName());
			userEntity.setPassword(userModel.getPassword());
			userEntity.setEmail(userModel.getEmail());
			userEntity.setCreatedOn(LocalDateTime.now());
			userRepository.save( userEntity);
		}
		else {
			log.error(" EmailAlreadyExistsException");
			throw new  EmailAlreadyExistsException("email already exists exception for the Id: " +userEntity1.getUserId());
		}
		
		log.info("UserService | addUser |End>>");
		
		
	}
	public void updateUserDetails(UserModel userModel) throws UserDoesNotExistException, ApplicationErrorException {
		log.info("userService | updateUserDetails| start>>");
		try {
		Optional<UserEntity> optionalUserEntity =userRepository.findById(userModel.getUserId());
		if(optionalUserEntity.isPresent()) {
			System.out.println("#$");
			UserEntity userEntity= optionalUserEntity .get();
			System.out.println(userEntity);
			userEntity.setUserName(userModel.getUserName());
			userEntity.setPassword(userModel.getPassword());
			userEntity.setEmail(userModel.getEmail());
			userEntity.setUpdatedOn(LocalDateTime.now());
			log.info("userService | updateUserDetails| end<<");
			userRepository.save(userEntity);
		}
		else {
			log.error("user does not exists for this Id");
			throw new UserDoesNotExistException("user not exists for this Id: "+ userModel.getUserId());
			
		}
		}
		catch(Exception ex) {
			log.error("user does not exists for this Id");
			System.out.println(ex);
			if(ex instanceof UserDoesNotExistException) {
				throw ex;
			}
log.error(" ApplicationErrorException ");
			
			throw new ApplicationErrorException("An unknown error happened",ex);
			}
		 log.info("UserService | getUserUserDetails |End>>");
		
			}
			

		
	
	public List<UserModel> getUsers() {
		log.info("UserService | getUsers | Start>>");
		 List<UserEntity> 	userList=userRepository.findAll();
		 List<UserModel> userModelList= new ArrayList<>();
		 for(UserEntity ue:userList) {
		 UserModel userModel= new UserModel();
		 userModel.setUserId(ue.getUserId());
		 userModel.setUserName(ue.getUserName());
		 userModel.setPassword(ue.getPassword());
		 userModel.setEmail(ue.getEmail());
		 userModelList.add(userModel);
		 }
		 log.info("UserService | getUsers |End>>");
		return  userModelList;
	}
	public UserModel getUser(int userId) {
		log.info("UserService | getUser | Start>>");
		//log.info(new Integer(userId).toString());
		 UserEntity user= userRepository.findById(userId).get();
		 UserModel userModel= new UserModel();
		 userModel.setUserId(user.getUserId());
		 userModel.setUserName(user.getUserName());
		 userModel.setPassword(user.getPassword());
		 userModel.setEmail(user.getEmail());
		 log.info("UserService |getUser |End>>");
		 return userModel;
		 }
	public void deleteUSer(int userId) {
		log.info("UserService | deleteUser | Start>>");
		
		userRepository.deleteById(userId);
		 log.info("UserService |deleteUser |End>>");
		}
	public List<UserModel> searchUser(String searchParam) {
		log.info("UserService | searchUser | Start>>");
		 List<UserEntity> 	userList=userRepository.searchProduct(searchParam);
		 List<UserModel> userModelList= new ArrayList<>();
		 for(UserEntity ue:userList) {
		 UserModel userModel= new UserModel();
		 userModel.setUserId(ue.getUserId());
		 userModel.setUserName(ue.getUserName());
		 userModel.setPassword(ue.getPassword());
		 userModel.setEmail(ue.getEmail());
		 userModelList.add(userModel);
		 }
		 log.info("UserService |searchUser |End>>");
		return  userModelList;
		}
	public UserDetailsResponse getUserDetails(int userId) throws UserDoesNotExistException, ApplicationErrorException {
		log.info("UserService | getUserDetails | Start>>");
		UserDetailsResponse  userDetailsResponse = new  UserDetailsResponse();
		try {
		Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
			if(optionalUserEntity.isPresent()) {
		 UserDetails userDetails =new UserDetails ();
		 UserEntity userD=optionalUserEntity.get();
		 userDetails.setUserId(userD.getUserId());
		 userDetails.setUserName(userD.getUserName());
		 userDetails.setEmail(userD.getEmail());
		 userDetailsResponse.setUserDetails(userDetails);
		 List<UserProductMappingEntity> user= cartRepository. basedOnUserId(userId);
		 List<CartItem> cartItems= new ArrayList<>();
		 for(UserProductMappingEntity upme:user) {
			 CartItem cartItem=new CartItem();
			 cartItem.setProductId(upme.getProductEntity().getProductId());
			 cartItem.setProductName(upme.getProductEntity().getProductName());
			 cartItem.setProductPrice(upme.getProductEntity().getProductPrice());
			 cartItem.setQuantity(upme.getQuantity());
			 cartItems.add(cartItem);
		 }
		 userDetailsResponse.setCartItems(cartItems);
		 List<WishlistEntity> user1= wishlistRepository.basedOnUserId(userId);
		 List<WishlistItem> wishlistItems= new ArrayList<>();
		 for(WishlistEntity we:user1) {
			 WishlistItem wishlistItem=new WishlistItem();
			 wishlistItem.setProductId(we.getProductEntity().getProductId());
			 wishlistItem.setProductName(we.getProductEntity().getProductName());
			 wishlistItem.setProductPrice(we.getProductEntity().getProductPrice());
			 wishlistItems.add(wishlistItem);
		 }
		 userDetailsResponse.setWistlistItems(wishlistItems);
		 //System.out.println(10/0);
		// int num[]= {1,2,3};
		 
		// System.out.println(num[4]);
		
	}
	
	else {
		log.error(" UserDoesNotExistException ");
		
		throw new UserDoesNotExistException("user not exists for this Id:"+ userId );
		
	}
		}
		catch(Exception e) {
			if(e instanceof UserDoesNotExistException) {
				log.error(" UserDoesNotExistException ");
				throw e;
			}
			log.error(" ApplicationErrorException ");
			
			throw new ApplicationErrorException("An unknown error happened",e);
			}
		 log.info("UserService | getUserUserDetails |End>>");
		 if(true)
				//throw new RuntimeException("some thing went wrong");
					throw new CheckedException("checkedExcception");
	return userDetailsResponse;
		
		}
	
		
	}


