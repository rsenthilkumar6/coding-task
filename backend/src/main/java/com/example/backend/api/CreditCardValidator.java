package com.example.backend.api;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.constants.Messages;
import com.example.backend.dto.RequestPayload;
import com.example.backend.dto.ResponsePayload;
import com.example.backend.services.CardValidatorService;


@RestController
@RequestMapping(path = "/api")
public class CreditCardValidator {
	
	@Autowired
	CardValidatorService validatorService;

	@PostMapping("/validate")
	ResponseEntity<String> validate(@RequestBody RequestPayload payload) {
		HttpStatus statusCode = HttpStatus.BAD_REQUEST;
		String responseMessage = Messages.INVALID_REQUEST;
		
		try {
			if (StringUtils.isNotBlank(payload.getCardNumber()) && StringUtils.isNumeric(payload.getCardNumber())) {
				ResponsePayload response = validatorService.validateCreditCardNumber(payload.getCardNumber());
				
				statusCode = HttpStatus.OK;
				responseMessage = response.toString();
			}
		} catch (Exception e) {
			// e.printStackTrace();
			
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			responseMessage = Messages.GENERIC_ERROR_MESSAGE;
		}
		
		return ResponseEntity.status(statusCode).body(responseMessage);
	}
	
}
