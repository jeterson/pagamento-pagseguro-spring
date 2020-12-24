package com.jeterson.pagseguro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeterson.pagseguro.domain.dto.Currency;
import com.jeterson.pagseguro.domain.dto.PaymentAmount;
import com.jeterson.pagseguro.domain.dto.PaymentCardHolder;
import com.jeterson.pagseguro.domain.dto.PaymentCardRequest;
import com.jeterson.pagseguro.domain.dto.PaymentMethodRequest;
import com.jeterson.pagseguro.domain.dto.PaymentRequest;
import com.jeterson.pagseguro.domain.dto.PaymentResponse;
import com.jeterson.pagseguro.domain.dto.PaymentType;
import com.jeterson.pagseguro.openfeign.PaymentFeign;

@EnableFeignClients
@SpringBootApplication
public class PagseguroApplication implements CommandLineRunner {

	@Autowired
	private PaymentFeign paymentFeign;
	
	public static void main(String[] args) {
		SpringApplication.run(PagseguroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PaymentRequest request = new PaymentRequest();
		request.setReferenceId("ex-0002");
		request.setDescription("Motivo da cobrança");
		
		PaymentAmount amount = new PaymentAmount();
		amount.setCurrency(Currency.BRL);
		amount.setValue(1000);
		request.setAmount(amount);
		
		PaymentMethodRequest paymentMethod = new PaymentMethodRequest();
		paymentMethod.setCapture(true);
		paymentMethod.setType(PaymentType.CREDIT_CARD);
		paymentMethod.setInstallments(1);
		
		PaymentCardRequest card = new PaymentCardRequest();
		card.setNumber("4111111111111111");
		card.setExpMonth("03");
		card.setExpYear("2026");
		card.setSecurityCode("123");
		PaymentCardHolder holder = new PaymentCardHolder();
		holder.setName("Jose da Silva");
		card.setHolder(holder);		
		paymentMethod.setCard(card);
		request.setPaymentMethod(paymentMethod);
		
		String json = new ObjectMapper().writeValueAsString(request);
		
		System.out.println(json);
		
		PaymentResponse response = paymentFeign.createPayment("Bearer 54A1FB2E9DC847FCACF7207921082AD3", "4.0", request).getBody();
		System.out.println(response.getReferenceId());
		
		
		
	}

}
