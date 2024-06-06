package com.sahafbanking.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahafbanking.main.model.entity.AdminLogin;
import com.sahafbanking.main.model.entity.BankAccountEntity;
import com.sahafbanking.main.model.entity.User;
import com.sahafbanking.main.model.entity.UserLogin;
import com.sahafbanking.main.repository.UserRepository;

@Service
public class UserServicesImpl implements UserServices {
	
	@Autowired
	UserRepository ur;

	@Override
	public void saveUser(User user) {
		ur.save(user);
	}

	@Override
	public User getUser(int userid) {
		ur.findById(userid).get();
		return null;
	}

	@Override
	public void deleterUser(int userid) {
		ur.deleteById(userid);
	}
	
	@Override
	public List<User> getAllUser() {
		return ur.findAll();
	}
	@Override
	public boolean authenticate(User user) {
		boolean user_exists=true;
		List<User> userdetails = ur.findAll();
		for(int i=0;i<userdetails.size();i++) {
			if(userdetails.get(i).getMobile().equalsIgnoreCase(user.getMobile())) {
				user_exists=false;
				break;
			}
		}
		return user_exists;
	}

	public boolean loginVerification(AdminLogin login) {
		List<User> users = getAllUser();
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getEmail().equalsIgnoreCase(login.getUsername()) && users.get(i).getPassword().equals(login.getPassword())) {
				return true;
			}
		}
		return false;
	}
	public User getAdminDetail(AdminLogin login) {
		User user = new User();
		List<User> users = getAllUser();
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getEmail().equalsIgnoreCase(login.getUsername()) && users.get(i).getPassword().equals(login.getPassword()) 
					&& users.get(i).getRole().equalsIgnoreCase("admin")) {
				user=users.get(i);
			}
		}
		return user;
	}
	public boolean userLoginVerification(UserLogin login) {
		
		List<User> users = getAllUser();
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getEmail().equalsIgnoreCase(login.getUsername()) && users.get(i).getPassword().equals(login.getPassword())) {
				return true;
			}
		}
		return false;
	}
	public User getUserDetail(UserLogin login) {
		User user = new User();
		List<User> users = getAllUser();
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getEmail().equalsIgnoreCase(login.getUsername()) && users.get(i).getPassword().equals(login.getPassword()) 
					&& users.get(i).getRole().equalsIgnoreCase("consumer")) {
				user=users.get(i);
			}
		}
		return user;
	}
}
