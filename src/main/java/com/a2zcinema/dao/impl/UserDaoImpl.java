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

	public void deleteUser(long id) {
		User user = new User();
		user.setId(id);
		this.hibernateUtilTo.delete(user);
	}

	public List<User> getAllUsers() {
		return hibernateUtilTo.fetchAll(User.class);
	}
	
	public User getUser(long id) {
		return hibernateUtilTo.fetchById(id, User.class);
	}
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(String userName) {
		String query = "SELECT u.* FROM users u WHERE u.name like '%"+ userName +"%'";
		List<Object[]> userObjects = (List<Object[]>) this.hibernateUtilTo.fetchAll(query);
		List<User> users = new ArrayList<User>();
		for(Object[] userObject: userObjects) {
			User user = new User();
			long id = ((BigInteger) userObject[0]).longValue();			
			int age =  (Integer) userObject[1];
			String name = (String) userObject[2];
			float salary = (Float) userObject[3];
			user.setId(id);
			user.setName(name);
			user.setAge(age);
			user.setSalary(salary);
			users.add(user);
		}
		System.out.println(users);
		return users;
	}
}