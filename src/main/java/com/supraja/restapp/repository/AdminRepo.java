package com.supraja.restapp.repository;

import java.util.List;

import com.supraja.restapp.model.Admin;

public interface AdminRepo 
{
public List<Integer> getIDList();
    
	void save(Admin admin);
	
	List<Admin> findAll();
	
	void deleteById(int adminid);
	
	Admin findById(int adminid);
}
