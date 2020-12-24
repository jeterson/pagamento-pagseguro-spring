package com.jeterson.pagseguro.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PaymentCardRequest {

	private String number;
	
	@JsonProperty(value = "exp_month")
	private String expMonth;
	
	@JsonProperty(value = "exp_year")
	private String expYear;
	
	@JsonProperty(value = "security_code")
	private String securityCode;
	
	private PaymentCardHolder holder;
}
