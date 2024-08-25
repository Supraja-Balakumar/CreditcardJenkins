package com.supraja.restapp.repository;



import org.springframework.stereotype.Repository;

import com.supraja.restapp.model.Loginreg;


@Repository
public interface LoginregRepo 
{
   String save(Loginreg loginreg);
   
   Loginreg findByUsername(String username);
}

