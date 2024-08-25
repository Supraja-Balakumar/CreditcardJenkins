package com.supraja.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supraja.restapp.model.User;
import com.supraja.restapp.repoimpl.UserRepoimpl;
import com.supraja.restapp.repository.UserRepo;
import com.supraja.restapp.service.UserService;


@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserRepo repo;

	@Override
	public User addUser(User user) {
		return repo.save(user);
	}

	@Override
	public User getUser(int id) {
		User user = repo.findById(id);
		return user;
	}

	@Override
	public List<User> getAllUser() {
		return repo.findAll();
	}

	@Override
	public void updateUser(User user) {
		repo.save(user);
		
	}

	@Override
	public void deleteUser(int id) {
		repo.deleteById(id);
		
	}
	
	public List<Integer> getAllId() {
		return repo.getIDList();
	}

	@Override
	public User findByEmail(String email) {
		 return repo.findByEmail(email);
	}


//	public User userLogin(String email, String password) {
//		return User.userLogin(email, password);
//	}
//	

	
}
