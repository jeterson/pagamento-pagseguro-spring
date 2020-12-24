package com.jeterson.pagseguro.domain.dto;

import lombok.Data;

@Data
public class PaymentAmountSummary {

	private Double total;
	private Double paid;
	private Double refunded;
	
}
