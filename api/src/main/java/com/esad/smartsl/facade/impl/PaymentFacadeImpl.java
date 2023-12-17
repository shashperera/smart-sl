package com.esad.smartsl.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esad.smartsl.domain.dto.PaymentDto;
import com.esad.smartsl.facade.PaymentFacade;
import com.esad.smartsl.service.PaymentService;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.PaymentSearchDto;

@Service
public class PaymentFacadeImpl implements PaymentFacade {

	@Autowired
	private PaymentService paymentService;

	@Override
	public ResponseDto<PaymentDto> createPayment(PaymentDto paymentDto) {
		ResponseDto<PaymentDto> responseDto = new ResponseDto<PaymentDto>();

		responseDto = paymentService.createPayment(paymentDto);

		return responseDto;
	}

	@Override
	public ResponseDto<PaymentDto> updatePayment(PaymentDto paymentDto) {
		ResponseDto<PaymentDto> responseDto = new ResponseDto<PaymentDto>();

		responseDto = paymentService.updatePayment(paymentDto);

		return responseDto;
	}

	@Override
	public ResponseDto<PaymentDto> searchPayment(PaymentSearchDto paymentSearchDto) throws Exception {
		ResponseDto<PaymentDto> responseDto = new ResponseDto<PaymentDto>();

		responseDto = paymentService.searchPayment(paymentSearchDto);

		return responseDto;
	}

	@Override
	public ResponseDto<PaymentDto> findPaymentById(PaymentSearchDto paymentSearchDto) {
		ResponseDto<PaymentDto> responseDto = new ResponseDto<PaymentDto>();

		responseDto = paymentService.findPaymentById(paymentSearchDto);

		return responseDto;
	}

	@Override
	public ResponseDto<PaymentDto> deletePayment(PaymentDto paymentDto) {
		ResponseDto<PaymentDto> responseDto = new ResponseDto<PaymentDto>();

		responseDto = paymentService.deletePayment(paymentDto);

		return responseDto;
	}

}
