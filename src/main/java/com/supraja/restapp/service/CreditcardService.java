package com.supraja.restapp.service;

import java.util.List;

import com.supraja.restapp.model.Creditcard;

public interface CreditcardService 
{
	public Creditcard addCreditcard(Creditcard creditcard);

	public Creditcard getCreditcard(int id);

	public List<Creditcard> getAllCreditcard();

	public void updateCreditcard(Creditcard creditcard);

	public void deleteCreditcard(int id);
	
//	public List<Creditcard> getPendingforms();
//	
//	public List<Creditcard> getApprovedforms();
//	
//	public List<Creditcard> getRejectedforms();
//	
//	public Object getApprovedCount();
//	
//	public Object getRejectedCount();
//	
//	public Object getPendingCount();
}
