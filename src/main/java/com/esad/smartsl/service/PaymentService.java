package com.esad.smartsl.service;

import com.esad.smartsl.domain.dto.PaymentDto;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.PaymentSearchDto;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PaymentService {

	ResponseDto<PaymentDto> createPayment(PaymentDto paymentDto);

	ResponseDto<PaymentDto> updatePayment(PaymentDto paymentDto);

	ResponseDto<PaymentDto> searchPayment(PaymentSearchDto paymentSearchDto) throws Exception;

	ResponseDto<PaymentDto> findPaymentById(PaymentSearchDto paymentSearchDto);

	ResponseDto<PaymentDto> deletePayment(PaymentDto paymentDto);

}
