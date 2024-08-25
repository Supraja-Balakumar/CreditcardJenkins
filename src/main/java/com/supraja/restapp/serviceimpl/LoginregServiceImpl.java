package com.supraja.restapp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supraja.restapp.model.Loginreg;
import com.supraja.restapp.repository.LoginregRepo;
import com.supraja.restapp.service.LoginregService;


@Service
public class LoginregServiceImpl implements LoginregService
{
	@Autowired
	LoginregRepo loginregRepo;

	@Override
	public Loginreg findByUsername(String username) {
		 return loginregRepo.findByUsername(username);
	}

	@Override
	public String saveLoginreg(Loginreg loginreg) {
        return loginregRepo.save(loginreg);
	}
}
