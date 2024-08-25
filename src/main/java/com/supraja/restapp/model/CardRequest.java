package com.supraja.restapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.CascadeType;

@Entity
@Table(name = "cardreq")
public class CardRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cardreqid;
	@Column
	private String cardtype;
	@Column
	private String jobTitle;
	@Column
	private String annualIncome;
	@Column
	private String accountType;
	@Column
	private String accountNumber;
	@Column
	private String cardStatus;

	@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	private User user;

	public int getCardid() {
		return cardreqid;
	}

	public void setCardreqid(int cardreqid) {
		this.cardreqid = cardreqid;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CardRequest(int cardreqid, String cardtype, String jobTitle, String annualIncome, String accountType,
			String accountNumber, String cardStatus, User user) {
		super();
		this.cardreqid = cardreqid;
		this.cardtype = cardtype;
		this.jobTitle = jobTitle;
		this.annualIncome = annualIncome;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.cardStatus = cardStatus;
		this.user = user;
	}

	public CardRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}