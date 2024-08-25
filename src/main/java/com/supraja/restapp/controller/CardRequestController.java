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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supraja.restapp.model.CardRequest;
import com.supraja.restapp.service.CardRequestService;
import com.supraja.restapp.serviceimpl.CardRequestServiceImpl;


@RestController
@RequestMapping("/cardreq")
@CrossOrigin(origins="http://localhost:3000")
public class CardRequestController 
{
	@Autowired
	private CardRequestServiceImpl service;
	
	@PostMapping
	public String insertCardRequest(@RequestBody CardRequest cardrequest) {
		String msg = "";
		try {
			service.addCardRequest(cardrequest);
			msg = "Successfully added";	
		} catch (Exception e) {
			msg = "Failure";
		}
		return msg;
	}

	@GetMapping("{id}")
	public CardRequest getCardRequestbyId(@PathVariable("id") int id) {
		return service.getCardRequest(id);
	}

	@GetMapping("/all")
	public List<CardRequest> getCardRequest() {
		return service.getAllCardRequest();
	}

	@PutMapping
	public String updateCardRequest(@RequestBody CardRequest cardrequest) {
		String msg = "";
		try {
			service.updateCardRequest(cardrequest);
			msg = "Updated Success";
		} catch (Exception e) {
			msg = "Updated Failure";
		}

		return msg;
	}

	@DeleteMapping("{id}")
	public String deleteCardRequest(@PathVariable int id) {
		String msg = "";
		try {
			service.deleteCardrequest(id);
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
	
    @PutMapping("/{id}")
    public CardRequest updateCardStatus(@PathVariable("id") int cardreqid, @RequestParam("cardStatus") String cardStatus) {
        return service.updateCardStatus(cardreqid, cardStatus);
    }
	
}
