package com.esad.smartsl.dto.requestDto;

import java.io.Serializable;

import com.esad.smartsl.domain.dto.PassengerCardDto;
import com.esad.smartsl.domain.dto.PaymentDto;

public class PassengerCardRequestDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 9000372234948377226L;

	private PaymentDto paymentDto;
	private PassengerCardDto passengerCardDto;

	public PaymentDto getPaymentDto() {
		return paymentDto;
	}

	public void setPaymentDto(PaymentDto paymentDto) {
		this.paymentDto = paymentDto;
	}

	public PassengerCardDto getPassengerCardDto() {
		return passengerCardDto;
	}

	public void setPassengerCardDto(PassengerCardDto passengerCardDto) {
		this.passengerCardDto = passengerCardDto;
	}

}
