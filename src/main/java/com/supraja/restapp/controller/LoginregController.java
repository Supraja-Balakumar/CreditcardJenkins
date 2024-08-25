package com.supraja.restapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supraja.restapp.model.Loginreg;
import com.supraja.restapp.service.LoginregService;


@RestController
@RequestMapping("/userloginreg")
@CrossOrigin(origins="http://localhost:3000")
public class LoginregController 
{
	@Autowired
	  LoginregService loginregService;
	  
	  @PostMapping("/register")
	  public String register(@RequestBody Loginreg loginreg) {
	      Loginreg existingUser = loginregService.findByUsername(loginreg.getUsername());
	      if (existingUser != null) {
	          return "username already exists";
	      }
	      loginregService.saveLoginreg(loginreg);
	      return "User registered successfully";
	  }
	  
	  @PostMapping("/login")
	  public String login(@RequestBody Loginreg loginreg) {
	      Loginreg existingUser = loginregService.findByUsername(loginreg.getUsername());
	      if (existingUser != null && loginreg.getPassword().equals( existingUser.getPassword())) {
	          return "Login successful";
	      } else {
	          return "Invalid credentials";
	      }
	  }
}
