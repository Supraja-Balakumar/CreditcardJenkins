package com.supraja.restapp.service;

import java.util.List;

import com.supraja.restapp.model.CardRequest;

public interface CardRequestService 
{
	public String addCardRequest(CardRequest cardrequest);

	public CardRequest getCardRequest(int id);

	public List<CardRequest> getAllCardRequest();

	public void updateCardRequest(CardRequest cardrequest);

	public void deleteCardrequest(int id);

	CardRequest updateCardStatus(int cardreqid, String cardStatus);
}
