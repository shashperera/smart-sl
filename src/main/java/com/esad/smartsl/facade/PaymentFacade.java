package com.esad.smartsl.facade;

import javax.transaction.Transactional;

import com.esad.smartsl.domain.dto.PaymentDto;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.PaymentSearchDto;

@Transactional
public interface PaymentFacade {

	ResponseDto<PaymentDto> createPayment(PaymentDto paymentDto);

	ResponseDto<PaymentDto> updatePayment(PaymentDto paymentDto);

	ResponseDto<PaymentDto> searchPayment(PaymentSearchDto paymentSearchDto) throws Exception;

	ResponseDto<PaymentDto> findPaymentById(PaymentSearchDto paymentSearchDto);

	ResponseDto<PaymentDto> deletePayment(PaymentDto paymentDto);

}
