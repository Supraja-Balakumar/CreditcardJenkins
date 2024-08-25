package com.supraja.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supraja.restapp.model.Admin;
import com.supraja.restapp.model.User;
import com.supraja.restapp.repoimpl.AdminRepoimpl;
import com.supraja.restapp.repository.AdminRepo;
import com.supraja.restapp.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	AdminRepoimpl repo;

	@Override
	public String addAdmin(Admin admin) {
		repo.save(admin);
		return "AddSuccess";
	}

	@Override
	public Admin getAdmin(int id) {
		Admin admin = repo.findById(id);
		return admin;
	}

	@Override
	public List<Admin> getAllAdmin() {
		return repo.findAll();
	}

	@Override
	public void updateAdmin(Admin admin) {
		repo.save(admin);
		
	}

	@Override
	public void deleteAdmin(int id) {
		repo.deleteById(id);
		
	}
	
	
}
