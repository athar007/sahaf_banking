package com.sahafbanking.main.service;
import java.util.List;

import com.sahafbanking.main.model.entity.AdminLogin;
import com.sahafbanking.main.model.entity.User;
import com.sahafbanking.main.model.entity.UserLogin;

public interface UserServices {
	
	void saveUser(User user);
	User getUser(int id);
	void deleterUser(int id);
	List<User> getAllUser();
	boolean authenticate(User user);
	public boolean loginVerification(AdminLogin login);
	User getAdminDetail(AdminLogin login);
	public boolean userLoginVerification(UserLogin userLogin);
	User getUserDetail(UserLogin userLogin);

}
