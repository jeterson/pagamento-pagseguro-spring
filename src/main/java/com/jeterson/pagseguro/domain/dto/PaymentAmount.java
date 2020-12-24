package com.jeterson.pagseguro.domain.dto;

import lombok.Data;

@Data
public class PaymentAmount {

	private Integer value;
	private Currency currency;
	private PaymentAmountSummary sumary;
		
	
	
	
}
