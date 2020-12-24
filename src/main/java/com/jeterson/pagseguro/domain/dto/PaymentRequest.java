package com.jeterson.pagseguro.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PaymentRequest {

	@JsonProperty("reference_id")
	private String referenceId;
	private String description;
	private PaymentAmount amount;
	
	@JsonProperty("payment_method")
	private PaymentMethodRequest paymentMethod;
}
