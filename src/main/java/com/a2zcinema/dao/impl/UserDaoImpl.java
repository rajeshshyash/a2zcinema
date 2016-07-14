package com.a2zcinema.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a2zcinema.dao.UserDao;
import com.a2zcinema.entity.User;
import com.a2zcinema.util.HibernateUtil;


@Repository
public class UserDaoImpl implements UserDao {
    
	public UserDaoImpl() {
    	System.out.println("UserDaoImpl()");
    }
	@Autowired
	public HibernateUtil hibernateUtilTo;
	
	public long createUser(User user) {
		return (Long)this.hibernateUtilTo.create(user);
	}

	public User updateUser(User user) {
		return hibernateUtilTo.update(user);
	}

	public void deleteUser(long userId) {
		User user = new User();
		user.setUserId(userId);
		this.hibernateUtilTo.delete(user);
	}

	public List<User> getAllUsers() {
		return hibernateUtilTo.fetchAll(User.class);
	}
	
	public User getUser(long userId) {
		return hibernateUtilTo.fetchById(userId, User.class);
	}
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(String userName) {
		String query = "SELECT u.* FROM users u WHERE u.username like '%"+ userName +"%'";
		List<Object[]> userObjects = (List<Object[]>) this.hibernateUtilTo.fetchAll(query);
		List<User> users = new ArrayList<User>();
		for(Object[] userObject: userObjects) {
			User user = new User();
			long userid = ((BigInteger) userObject[0]).longValue();			
			String useName = (String) userObject[1];
			String firstName = (String) userObject[2];
			String lastName = (String) userObject[3];
			String email = (String) userObject[4];
			long mob = ((BigInteger) userObject[5]).longValue();
			user.setUserId(userid);
			user.setUserName(useName);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmailId(email);
			user.setMobile(mob);
			users.add(user);
		}
		System.out.println(users);
		return users;
	}
}