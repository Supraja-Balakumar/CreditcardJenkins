package com.supraja.restapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supraja.restapp.model.CardRequest;
import com.supraja.restapp.repoimpl.CardRequestRepoimpl;
import com.supraja.restapp.repository.CardRequestRepo;
import com.supraja.restapp.service.CardRequestService;

@Service
public class CardRequestServiceImpl implements CardRequestService {
	@Autowired
	CardRequestRepoimpl repo;

	@Override
	public String addCardRequest(CardRequest cardrequest) {
		repo.save(cardrequest);
		return "AddSuccess";
	}

	@Override
	public CardRequest getCardRequest(int id) {
		CardRequest cardrequest = repo.findById(id);
		return cardrequest;
	}

	@Override
	public List<CardRequest> getAllCardRequest() {
		return repo.findAll();
	}

	@Override
	public void updateCardRequest(CardRequest cardrequest) {
		repo.save(cardrequest);

	}

	@Override
	public void deleteCardrequest(int id) {
		repo.deleteById(id);

	}

	public List<Integer> getAllId() {
		return repo.getIDList();
	}

	@Override
    public CardRequest updateCardStatus(int cardreqid, String cardStatus) {
        return repo.updateCardStatus(cardreqid, cardStatus);
    }
	
	

}
