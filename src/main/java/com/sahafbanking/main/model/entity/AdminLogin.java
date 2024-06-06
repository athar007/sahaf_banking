package com.sahafbanking.main.model.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AdminLogin {
	@NotBlank(message="Email can't be empty")
	@Email(regexp = "[a-z0-9#$%&][a-z0-9#$%&'\\.\\-_]*@[^\\.\\s@][a-z0-9_\\.\\-_]*\\.[a-z]{2,4}"
			, message="Envalid email!!")
	private String username;
	@NotBlank(message="Password can't be empty")
	@Size(min=5 ,max=15, message="Password must be of 5-15 Charachters (A-Z, a-z format only)")
	@Pattern(regexp="^\\d*[a-zA-Z][a-zA-Z0-9]*$", message="Password must be Charachters and digits only!")
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminLogin [username=" + username + ", password=" + password + "]";
	}
	
}
