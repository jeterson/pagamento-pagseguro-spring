package com.jeterson.pagseguro.domain.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;

@Data
public class PaymentResponse {

	private String id;
	@JsonProperty("reference_id")
	private String referenceId;
	
	private PaymentStatus status;
	
	@JsonProperty("created_at")
	private Date createdAt;
	
	private PaymentAmount amount;
	
	@JsonProperty("payment_response")
	private PaymentApiResponse paymentResponse;
	
	@JsonProperty("payment_method")
	private PaymentMethodResponse paymentMethod;
	
	
	@Getter
	private List<PaymentLink> links = new ArrayList<PaymentLink>();
	
	@Getter
	@JsonProperty("notification_url")
	private List<String> notificarionUrls = new ArrayList<String>(); 
	
	private Object metadata;
	
	 
}
