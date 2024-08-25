package com.supraja.restapp.repository;

import java.util.List;

import com.supraja.restapp.model.CardRequest;

public interface CardRequestRepo {
	public List<Integer> getIDList();

	void save(CardRequest cardrequest);

	List<CardRequest> findAll();

	void deleteById(int cardreqid);

	CardRequest findById(int cardreqid);
	
	public CardRequest updateCardStatus(int cardreqid, String cardStatus);
}
