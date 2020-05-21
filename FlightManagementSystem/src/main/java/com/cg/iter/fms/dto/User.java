package com.cg.iter.fms.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.math.BigInteger;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NotEmpty(message="User Type is mandatory. Please provide user type")
    private String userType;

    @NotEmpty(message="User Name is mandatory. Please provide user name")
    @Size(min=2, message="Name should have atleast 5 characters")
    private String userName;

    @NotEmpty(message="User email is mandatory. Please provide user email")
    private String email;
    
    
    private Long userPhone;

    private String password;

    public User() {
    }

    public User(String userType, String userName, String email, Long userPhone, String password) {
        this.userType = userType;
        this.userName = userName;
        this.email = email;
        this.userPhone = userPhone;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userType=" + userType + ", userName=" + userName + ", email=" + email
				+ ", userPhone=" + userPhone + ", password=" + password + "]";
	}
}
