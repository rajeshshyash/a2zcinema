
package com.a2zcinema.service;
import java.util.List;

import com.a2zcinema.entity.User;

public interface UserService {
	public long createUser(User user);
    public User updateUser(User user);
    public void deleteUser(long userId);
    public List<User> getAllUsers();
    public User getUser(long userId);	
	public List<User> getAllUsers(String userName);
}
