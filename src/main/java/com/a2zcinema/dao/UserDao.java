package com.a2zcinema.dao;

import java.util.List;

import com.a2zcinema.entity.User;


public interface UserDao {
	public long createUser(User user);
    public User updateUser(User user);
    public void deleteUser(long id);
    public List<User> getAllUsers();
    public User getUser(long id);	
	public List<User> getAllUsers(String userName);
}
