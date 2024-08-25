package com.supraja.restapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supraja.restapp.model.User;
import com.supraja.restapp.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:3000")
public class UserController 
{
  @Autowired
  private UserService service;
  
  @PostMapping
	public String insertUser(@RequestBody User user) {
		String msg = "";
		try {
			service.addUser(user);
			msg = "Successfull";
		} catch (Exception e) {
			msg = "Failure";
		}

		return msg;
	}
  
  @GetMapping("{id}")
	public User getUserbyId(@PathVariable("id") int id) {
		return service.getUser(id);
	}
  
  @GetMapping("/all")
	public List<User> getUser() {
		return service.getAllUser();
	}
  
  @PutMapping
	public String updateUser(@RequestBody User user) {
		String msg = "";
		try {
			service.updateUser(user);
			msg = " Update Success";
		} catch (Exception e) {
			msg = "Failure update";
		}

		return msg;
	}
  
  @GetMapping("/idlist")
	public List<Integer> getIDList() {
		return service.getAllId();
	}
  
  @PostMapping("/register")
  public User register(@RequestBody User user) {
      return service.addUser(user);
  }
  
//  @GetMapping("/login/{email}/{password}")
//	public User loginUser(@PathVariable("email") String email,
//			@PathVariable("password") String password) {
//
//		return service.userLogin(email, password);
//
//	}
	

  
  
  @PostMapping("/login")
  public User login(@RequestBody User user) {
      User existingUser = service.findByEmail(user.getEmail());

      if (existingUser != null && user.getPassword().equals(existingUser.getPassword())) {
          return existingUser;
      } else {
          return null;
      }
  }
}


