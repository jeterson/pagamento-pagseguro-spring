package com.jeterson.pagseguro.domain.dto;

import lombok.Data;

@Data
public class PaymentApiResponse {

	private String code;
	
	private String message;
	private String reference;
}
