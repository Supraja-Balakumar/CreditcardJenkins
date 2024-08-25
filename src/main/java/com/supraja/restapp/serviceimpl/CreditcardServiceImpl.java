package com.supraja.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supraja.restapp.model.Creditcard;
import com.supraja.restapp.repoimpl.CreditcardRepoimpl;
import com.supraja.restapp.service.CreditcardService;

@Service
public class CreditcardServiceImpl implements CreditcardService 
{
	@Autowired
	CreditcardRepoimpl repo;

	@Override
	public Creditcard addCreditcard(Creditcard creditcard) {
		return repo.save(creditcard);
	}

	@Override
	public Creditcard getCreditcard(int id) {
		Creditcard creditcard = repo.findById(id);
		return creditcard;
	}

	@Override
	public List<Creditcard> getAllCreditcard() {
		return repo.findAll();
	}

	@Override
	public void updateCreditcard(Creditcard creditcard) {
		repo.save(creditcard);
		
	}

	@Override
	public void deleteCreditcard(int id) {
		repo.deleteById(id);
		
	}
	
	public List<Integer> getAllId() {
		return repo.getIDList();
	}
	
	
	 public Creditcard getCreditcardByUserId(int userId) {
	        return repo.findByUserId(userId);
	    }
	 
	 
//	@Override
//	public List<Creditcard> getPendingforms() {
//		return repo.getPendingTaxReturns();
//	}
// 
//	@Override
//	public List<Creditcard> getApprovedforms() {
//		return repo.getApprovedTaxReturns();
//	}
// 
//	@Override
//	public List<Creditcard> getRejectedforms() {
//		return repo.getRejectedTaxReturns();
//	}
//	
//	@Override
//	public Object getApprovedCount() {
//		return repo.getApprovedCount();
//	}
// 
//	@Override
//	public Object getRejectedCount() {
//		return repo.getRejectedCount();
//	}
// 
//	@Override
//	public Object getPendingCount() {
//		return repo.getPendingCount();
//	}
//
//	public boolean updateApprovedForm(int id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	public boolean updateRejectedForm(int id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
 
}
