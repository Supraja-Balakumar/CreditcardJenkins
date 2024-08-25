package com.supraja.restapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.CascadeType;

@Entity
@Table(name = "creditcard")
public class Creditcard 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int cardid;
	@Column
	private String cardholderName;
	@Column
	private String cardnumber;
	@Column
	private String expirationDate;
	@Column
	private String cvv;
	
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	private User user;

	public int getCardid() {
		return cardid;
	}

	public void setCardid(int cardid) {
		this.cardid = cardid;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Creditcard(int cardid, String cardholderName, String cardnumber, String expirationDate, String cvv,
			User user) {
		super();
		this.cardid = cardid;
		this.cardholderName = cardholderName;
		this.cardnumber = cardnumber;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
		this.user = user;
	}

	public Creditcard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
