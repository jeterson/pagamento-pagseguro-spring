package com.jeterson.pagseguro.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.jeterson.pagseguro.domain.dto.PaymentRequest;
import com.jeterson.pagseguro.domain.dto.PaymentResponse;

@Component
@FeignClient( value = "PagSeguro", url = "https://sandbox.api.pagseguro.com", path = "/charges")
public interface PaymentFeign {

	@PostMapping
	ResponseEntity<PaymentResponse> createPayment(@RequestHeader("Authorization") String token, @RequestHeader("x-api-version") String version, @RequestBody PaymentRequest payment);
}
