package com.supraja.restapp.service;

import com.supraja.restapp.model.Loginreg;

public interface LoginregService 
{
    Loginreg findByUsername(String username);
	
    String saveLoginreg(Loginreg loginreg);
}
