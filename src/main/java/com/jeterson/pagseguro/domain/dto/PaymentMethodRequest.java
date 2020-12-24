package com.jeterson.pagseguro.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentMethodRequest extends AbstractPaymentMethod {

	private PaymentCardRequest card;
}
