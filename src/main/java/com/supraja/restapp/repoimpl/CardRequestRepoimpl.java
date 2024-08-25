package com.supraja.restapp.repoimpl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.supraja.restapp.model.CardRequest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Repository
@Transactional
public class CardRequestRepoimpl 
{
  @Autowired
  private EntityManager entityManager;
  
  public List<Integer> getIDList() {
		String jpql="Select c.cardreqid from CardRequest c";
		TypedQuery<Integer> query = entityManager.createQuery(jpql,Integer.class);
		return query.getResultList();
	}

	public void save(CardRequest cardrequest) {
		
		entityManager.merge(cardrequest);
	}

	public List<CardRequest> findAll() {
		String jpql="From CardRequest";
		TypedQuery<CardRequest> query = entityManager.createQuery(jpql,CardRequest.class);
		return query.getResultList();
	}

	public void deleteById(int cardreqid) {
		String jpql="delete from CardRequest where cardreqid=" +cardreqid;
		entityManager.createQuery(jpql).executeUpdate();
	}

	public CardRequest findById(int cardreqid) {
		return entityManager.find(CardRequest.class, cardreqid);
	}

	public CardRequest updateCardStatus(int cardreqid, String cardStatus) {
        CardRequest cardRequest = entityManager.find(CardRequest.class, cardreqid);
        if (cardRequest != null) {
            cardRequest.setCardStatus(cardStatus);
            entityManager.merge(cardRequest);
        }
        return cardRequest;
    }  
}
