package com.lalli.eCart.entity;

    import java.time.LocalDateTime;
import java.util.Set;
    import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;

import javax.persistence.Table;

	@Entity
	@Table(name="users")

	public class UserEntity {
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Id
		@Column(name="userId")
		private int userId;
		@Column(name="userName")
		private String userName;
		@Column(name="password")
		private String password;
		@Column(name="email")
		private String email;
		@OneToMany(mappedBy="userEntity")
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
			userProductMappingEntity = userProductMappingEntity;
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
			return "UserEntity [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email="
					+ email + ", userProductMappingEntity=" + userProductMappingEntity + ", createdOn=" + createdOn
					+ ", updatedOn=" + updatedOn + "]";
		}
		
		
		
	}


