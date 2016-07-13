package com.a2zcinema.service.impl;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a2zcinema.dao.UserDao;
import com.a2zcinema.entity.User;
import com.a2zcinema.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	public UserServiceImpl() {
		System.out.println("UserServiceImpl()");
	}
	@Autowired
	private UserDao userDaoTO;
	
	public long createUser(User user) {
		return userDaoTO.createUser(user);
	}

	public User updateUser(User user) {
		return userDaoTO.updateUser(user);
	}

	public void deleteUser(long id) {
		userDaoTO.deleteUser(id);
	}

	public List<User> getAllUsers() {
		return userDaoTO.getAllUsers();
	}

	public User getUser(long id) {
		return userDaoTO.getUser(id);
	}

	public List<User> getAllUsers(String userName) {
		return userDaoTO.getAllUsers(userName);
	}
	
}
