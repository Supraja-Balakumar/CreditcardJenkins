package com.supraja.restapp.service;

import java.util.List;

import com.supraja.restapp.model.Loginreg;
import com.supraja.restapp.model.User;


public interface UserService 
{
	public User addUser(User user);

	public User getUser(int id);

	public List<User> getAllUser();

	public void updateUser(User user);

	public void deleteUser(int id);
	
    User findByEmail(String email);

	public List<Integer> getAllId();
	
}
