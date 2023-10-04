package com.lalli.eCart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lalli.eCart.exception.ApplicationErrorException;
import com.lalli.eCart.exception.EmailAlreadyExistsException;
import com.lalli.eCart.exception.UserDoesNotExistException;
import com.lalli.eCart.model.UserDetailsResponse;
import com.lalli.eCart.model.UserModel;
import com.lalli.eCart.service.UserService;
@RestController
public class UserController {
	@Autowired
	UserService userService;
	@PostMapping("/addUser")
	private String addUser(@Valid @RequestBody UserModel userModel) throws EmailAlreadyExistsException {
		userService.addUser(userModel);
		return "user Added Successfully";
	}
	@PutMapping("/updateUserDetails")
	private String upadateUserDetails(@Valid @RequestBody UserModel userModel ) throws UserDoesNotExistException, ApplicationErrorException {
		userService.updateUserDetails(userModel);
		return ("user details successfully updated for this Id: " + userModel.getUserId());
		
	}
	@GetMapping("/getUsers")
	private List<UserModel> getUsers(){
		return userService.getUsers();
	}
	@GetMapping("/getUser/{id}")
	private UserModel getUser(@PathVariable ("id") int userId) {
		return userService.getUser(userId);
	}
	@DeleteMapping("/deleteUser/{id}")
	private String deleteUSer(@PathVariable ("id") int userId) {
		 userService.deleteUSer(userId);
		 return "user deleted Successfully";
	}
	@GetMapping("/searchUser/{searchParam}")
	private List<UserModel> searchUser(@PathVariable ("searchParam") String searchParam){
		return userService.searchUser(searchParam);
	}
	@GetMapping("/getUserDetails/{userId}")
	private UserDetailsResponse getUserDetails(@PathVariable("userId") int userId)throws UserDoesNotExistException, ApplicationErrorException {
		return userService.getUserDetails(userId);
	}
	@GetMapping("/getUserI")
	private String getUSer1(@RequestParam int id) {
		System.out.println(id);
		return "when there is no variable in uri";
	}
	@GetMapping("/getUserS")
	private String getUSer2(@RequestParam String name) {
		System.out.println(name);
		return "when there is no variable in uri";
	}
	@GetMapping("/getUserIF")
	private String getUSer3(@RequestParam(required=false) int id) {
		System.out.println(id);
		return "when there is no variable in uri";
	}
	@GetMapping("/getUserSF")
	private String getUSer4(@RequestParam (required=false)String name) {
		System.out.println(name);
		return "when there is no variable in uri";
	}
}
