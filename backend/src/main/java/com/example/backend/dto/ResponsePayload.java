package com.example.backend.dto;

import com.example.backend.constants.CardTypes;

public class ResponsePayload {
	
	private CardTypes cardType;
	private String cardNumber;
	private boolean isValid;
	
	public ResponsePayload(String cardNumber) {
		this.cardNumber = cardNumber;
		this.cardType = CardTypes.Unknow;
		this.isValid = false;
	}

	@Override
	public String toString() {
		return
			cardType.toString() + 
			": " + 
			cardNumber + 
			(isValid == true ? " (valid)" : " (invalid)"); 
	}

	public CardTypes getCardType() {
		return cardType;
	}

	public void setCardType(CardTypes cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	
}
