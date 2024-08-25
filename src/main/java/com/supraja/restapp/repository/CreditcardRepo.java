package com.supraja.restapp.repository;

import java.util.List;

import com.supraja.restapp.model.Creditcard;

public interface CreditcardRepo 
{
void save(Creditcard creditcard);
	
public List<Integer> getIDList();

	List<Creditcard> findAll();
	
	void deleteById(int cardid);
	
	Creditcard findById(int cardid);
	
	 Creditcard findByUserId(int userId);
	
//	public List<Creditcard> getPendingTaxReturns();
//	
//	public List<Creditcard> getApprovedTaxReturns();
//	
//	public List<Creditcard> getRejectedTaxReturns();
//	
//	public Object getApprovedCount();
//	
//	public Object getRejectedCount();
//	
//	public Object getPendingCount();
//	
//	public boolean updateEmailApproved(int id);
	
	
}
