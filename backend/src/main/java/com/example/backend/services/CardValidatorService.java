package com.example.backend.services;

import org.springframework.stereotype.Service;

import com.example.backend.constants.CardTypes;
import com.example.backend.dto.ResponsePayload;

@Service
public class CardValidatorService {

	/**
	 * Performs two step validation for the given credit card number
	 * 
	 * @param cardNumber
	 * @return Response Payload Object
	 */
	public ResponsePayload validateCreditCardNumber(String cardNumber) {
		ResponsePayload response = new ResponsePayload(cardNumber);

		// Validation #1 - Based on start digit and length
		CardTypes cardType = getCardType(cardNumber);

		// Validation #2 - Based on Luhn Algorithm
		boolean isValid = luhnAlgorithmCheck(cardNumber);

		response.setCardType(cardType);
		response.setValid(isValid);

		return response;
	}

	/**
	 * Luhn Alogrithm to valid the Given Credit Card
	 * 
	 * 1. starting with next to last going backwards double the digits 2. sum all
	 * doubled and untouched digits; for digits >9 split & sum them independently 3.
	 * if total is multiple of 10, number is valid
	 * 
	 * input validation is completed at presentation layer hence less chance of
	 * error ;-P no try/catch
	 * 
	 * @param cardNumber
	 * @return isValid or Not (boolean value)
	 */
	public boolean luhnAlgorithmCheck(String cardNumber) {
		boolean validationResult = false;

		int[] ccNumber = new int[cardNumber.length()];

		// Converting card number string to int array
		for (int index = 0; index < cardNumber.length(); index++) {
			ccNumber[index] = Integer.parseInt(cardNumber.substring(index, index + 1));
		}

		// Step #1 of luhn algorithm
		for (int index = ccNumber.length - 2; index >= 0; index = index - 2) {
			int doubledValue = ccNumber[index] * 2;

			if (doubledValue > 9) {
				doubledValue = doubledValue % 10 + 1;
			}

			ccNumber[index] = doubledValue;
		}

		// Step #2 of luhn algorithm
		int totalValue = 0;
		for (int index = 0; index < ccNumber.length; index++) {
			totalValue += ccNumber[index];
		}

		// Step #3 of luhn algorithm
		if (totalValue % 10 == 0) {
			validationResult = true;
		}

		return validationResult;
	}

	/**
	 * Utility method to get the card type based on startswith & length
	 * 
	 * @param cardNumber
	 * @return CardType (enum)
	 */
	public CardTypes getCardType(String cardNumber) {

		if ((cardNumber.startsWith("34") || cardNumber.startsWith("37")) && cardNumber.length() == 15) {
			return CardTypes.AMEX;

		} else if (cardNumber.startsWith("6011") && cardNumber.length() == 16) {
			return CardTypes.Discover;

		} else if ((cardNumber.startsWith("51") || cardNumber.startsWith("52") || cardNumber.startsWith("53")
				|| cardNumber.startsWith("54") || cardNumber.startsWith("55")) && cardNumber.length() == 16) {
			return CardTypes.MasterCard;

		} else if (cardNumber.startsWith("4") && (cardNumber.length() == 13 || cardNumber.length() == 16)) {
			return CardTypes.VISA;
		}

		return CardTypes.Unknow;
	}

}
