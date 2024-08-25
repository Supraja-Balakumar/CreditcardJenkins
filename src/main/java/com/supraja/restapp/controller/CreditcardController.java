package com.supraja.restapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supraja.restapp.model.Creditcard;
import com.supraja.restapp.serviceimpl.CreditcardServiceImpl;

@RestController
@RequestMapping("/creditcard")
@CrossOrigin(origins="http://localhost:3000")
public class CreditcardController 
{
	@Autowired
	private CreditcardServiceImpl service;
	
	@PostMapping
	public Creditcard insertCreditcard(@RequestBody Creditcard creditcard) {
		
		return	service.addCreditcard(creditcard);
			
	}

	@GetMapping("{id}")
	public Creditcard getCreditcardbyId(@PathVariable("id") int id) {
		return service.getCreditcard(id);
	}

	@GetMapping("/all")
	public List<Creditcard> getCreditcard() {
		return service.getAllCreditcard();
	}

	@PutMapping
	public String updateCreditcard(@RequestBody Creditcard creditcard) {
		String msg = "";
		try {
			service.updateCreditcard(creditcard);
			msg = "Updated Success";
		} catch (Exception e) {
			msg = "Updated Failure";
		}

		return msg;
	}

	@DeleteMapping("{id}")
	public String deleteCreditcard(@PathVariable int id) {
		String msg = "";
		try {
			service.deleteCreditcard(id);
			msg = "Deleted Successfully";
		} catch (Exception e) {
			msg = "Deletion Failure";
		}

		return msg;
	}
		
	@GetMapping("/idlist")
	public List<Integer> getIDList() {
		return service.getAllId();
	}
	
	 @GetMapping("/user/{userId}")
	    public Creditcard getCreditcardByUserId(@PathVariable("userId") int userId) {
	        return service.getCreditcardByUserId(userId);
	    }
	
}