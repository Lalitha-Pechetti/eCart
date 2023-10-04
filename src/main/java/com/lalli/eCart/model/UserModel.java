package com.lalli.eCart.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.lalli.eCart.entity.UserProductMappingEntity;

public class UserModel {
	private int userId;
	
	@NotNull(message="cannot be blank")
	@Size(min=1,max=25)
	private String userName;
	@NotEmpty(message="cannot be blank")
	@Size(min=1,max=25,message="{validation.password.size}")
	private String password;
	@Size(min=1,max=25,message="The email'${validatedValue}' must be between {min} and {max} characters long")
	@NotBlank(message="cannot be blank")
	@Email
	private String email;
	private Set<UserProductMappingEntity > userProductMappingEntity ;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<UserProductMappingEntity> getUserProductMappingEntity() {
		return userProductMappingEntity;
	}

	public void setUserProductMappingEntity(Set<UserProductMappingEntity> userProductMappingEntity) {
		this.userProductMappingEntity = userProductMappingEntity;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", userProductMappingEntity=" + userProductMappingEntity + ", createdOn=" + createdOn + ", updatedOn="
				+ updatedOn + "]";
	}
	
}
