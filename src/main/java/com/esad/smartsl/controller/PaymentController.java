package com.esad.smartsl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esad.smartsl.domain.dto.PaymentDto;
import com.esad.smartsl.facade.PaymentFacade;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.PaymentSearchDto;

@RestController
@RequestMapping("/smartsl")
public class PaymentController {

	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

	@Autowired
	private PaymentFacade paymentFacade;

	@PostMapping("/create-payment")
	public ResponseEntity<ResponseDto<PaymentDto>> createPayment(@RequestBody PaymentDto paymentDto) {

		return new ResponseEntity<>(paymentFacade.createPayment(paymentDto), HttpStatus.OK);

	}

	@PostMapping("/update-payment")
	public ResponseEntity<ResponseDto<PaymentDto>> updatePayment(@RequestBody PaymentDto paymentDto) {

		return new ResponseEntity<>(paymentFacade.updatePayment(paymentDto), HttpStatus.OK);

	}

	@PostMapping("/search-payment")
	public ResponseEntity<ResponseDto<PaymentDto>> searchPayment(@RequestBody PaymentSearchDto paymentSearchDto)
			throws Exception {

		return new ResponseEntity<>(paymentFacade.searchPayment(paymentSearchDto), HttpStatus.OK);

	}

	@PostMapping("/find-payment-by-id")
	public ResponseEntity<ResponseDto<PaymentDto>> findPaymentById(@RequestBody PaymentSearchDto paymentSearchDto) {

		return new ResponseEntity<>(paymentFacade.findPaymentById(paymentSearchDto), HttpStatus.OK);

	}

	@PostMapping("/delete-payment")
	public ResponseEntity<ResponseDto<PaymentDto>> deletePayment(@RequestBody PaymentDto paymentDto) {

		return new ResponseEntity<>(paymentFacade.deletePayment(paymentDto), HttpStatus.OK);

	}

}
