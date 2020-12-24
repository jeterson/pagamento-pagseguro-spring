package com.jeterson.pagseguro.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentMethodResponse extends AbstractPaymentMethod {

	private PaymentCardResponse card;
}
