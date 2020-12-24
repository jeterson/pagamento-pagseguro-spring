package com.jeterson.pagseguro.domain.dto;

import lombok.Data;

@Data
public abstract class AbstractPaymentMethod {

	private PaymentType type;
	private Integer installments;	
	private boolean capture;
	
}
