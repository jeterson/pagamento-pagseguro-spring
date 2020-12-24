package com.jeterson.pagseguro.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PaymentCardResponse {

	private String number;
	
	private String brand;
	@JsonProperty("first_digits")
	private String firstDigits;
	
	@JsonProperty("last_digits")
	private String lastDigits;
	
	@JsonProperty(value = "exp_month")
	private String expMonth;
	
	@JsonProperty(value = "exp_year")
	private String expYear;
	
	private PaymentCardHolder holder;
}
