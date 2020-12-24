package com.jeterson.pagseguro.domain.dto;

import lombok.Data;

@Data
public class PaymentLink {

	private String rel;
	private String href;
	private String media;
	private String type;
}
