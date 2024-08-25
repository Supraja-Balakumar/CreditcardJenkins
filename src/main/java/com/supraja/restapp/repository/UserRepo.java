package com.supraja.restapp.repository;

import java.util.List;

import com.supraja.restapp.model.Loginreg;
import com.supraja.restapp.model.User;

public interface UserRepo 
{
public List<Integer> getIDList();
    
	User save(User user);
	
	List<User> findAll();
	
	void deleteById(int id);
	
	User findById(int id);
	
	   
	   User findByEmail(String email);
}
