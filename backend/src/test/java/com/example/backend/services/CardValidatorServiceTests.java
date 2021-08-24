package com.example.backend.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.backend.constants.CardTypes;

public class CardValidatorServiceTests {

	CardValidatorService validatorService;
	
	@BeforeEach                                 
    void setUp() {
		validatorService = new CardValidatorService();
    }
	
	@Test
	public void testLuhnAlgorithmCheck() {
		// Visa
		boolean shouldBeValid = validatorService.luhnAlgorithmCheck("4111111111111111");
		assertTrue(shouldBeValid);
		
		// Amex
		shouldBeValid = validatorService.luhnAlgorithmCheck("378282246310005");
		assertTrue(shouldBeValid);
		
		// Invalid Visa
		shouldBeValid = validatorService.luhnAlgorithmCheck("4111111111111");
		assertFalse(shouldBeValid);
		
		// Invalid MasterCard
		shouldBeValid = validatorService.luhnAlgorithmCheck("5105105105105106");
		assertFalse(shouldBeValid);
		
	}
	
	@Test
	public void testGetCardTypes() {
		// Visa Valid
		CardTypes type = validatorService.getCardType("4111111111111111");
		assertEquals(type.toString(), "VISA");
		
		// AMEX Valid
		type = validatorService.getCardType("378282246310005");
		assertEquals(type.toString(), "AMEX");
		
		// Discover Valid
		type = validatorService.getCardType("6011111111111117");
		assertEquals(type.toString(), "Discover");
		
		// MasterCard Valid
		type = validatorService.getCardType("5105105105105100");
		assertEquals(type.toString(), "MasterCard");

		// Unknow 
		type = validatorService.getCardType("9111111111111111");
		
	}
}
