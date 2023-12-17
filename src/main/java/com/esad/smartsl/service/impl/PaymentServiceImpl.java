package com.esad.smartsl.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.esad.smartsl.domain.dto.PaymentDto;
import com.esad.smartsl.domain.entity.Payment;
import com.esad.smartsl.domain.entity.QPayment;
import com.esad.smartsl.repository.PaymentRepository;
import com.esad.smartsl.service.PaymentService;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.PaymentSearchDto;
import com.esad.smartsl.enums.OrderDirection;
import com.google.common.collect.Lists;

@Service
public class PaymentServiceImpl implements PaymentService {

	private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ResponseDto<PaymentDto> createPayment(PaymentDto paymentDto) {

		// get the current date and time
		Date today = new Date();

		paymentDto.setCreatedAt(new Timestamp(today.getTime()));

		Payment payment = mapper.map(paymentDto, Payment.class);

		payment = paymentRepository.save(payment);

		ResponseDto<PaymentDto> responseDto = new ResponseDto<>();
		responseDto.setObject(mapper.map(payment, PaymentDto.class));

		return responseDto;
	}

	@Override
	public ResponseDto<PaymentDto> updatePayment(PaymentDto paymentDto) {

		Payment payment = paymentRepository.findById(paymentDto.getId()).orElse(null);

		if (payment != null) {

			payment.setReference(paymentDto.getReference());
			payment.setTxnTime(paymentDto.getTxnTime());
			payment.setTxnAmount(paymentDto.getTxnAmount());
			payment.setTxnMedia(paymentDto.getTxnMedia());
			payment.setPaymentStatus(paymentDto.getPaymentStatus());

			// getting current date and time
			Date today = new Date();

			payment.setUpdatedAt(new Timestamp(today.getTime()));
			payment.setUpdatedBy(paymentDto.getUpdatedBy());

			payment = paymentRepository.save(payment);

			paymentDto = mapper.map(payment, PaymentDto.class);

		}

		ResponseDto<PaymentDto> responseDto = new ResponseDto<>();
		responseDto.setObject(paymentDto);

		return responseDto;

	}

	@Override
	public ResponseDto<PaymentDto> searchPayment(PaymentSearchDto paymentSearchDto) throws Exception {

		QPayment payment = QPayment.payment;

		// setting pagination
		Pageable paging = PageRequest.of(paymentSearchDto.getCurrentPage(), paymentSearchDto.getPageSize(),
				paymentSearchDto.getOrderDirection() == OrderDirection.ASC
						? Sort.by(paymentSearchDto.getSortBy()).ascending()
						: Sort.by(paymentSearchDto.getSortBy()).descending());

		Iterable<Payment> paymentEntries = paymentRepository.findAll(
				payment.reference.containsIgnoreCase(paymentSearchDto.getReference())
						.and(payment.paymentType.eq(paymentSearchDto.getPaymentType()))
						.and(payment.user.id.eq(paymentSearchDto.getUserId()).and(payment.isDeleted.isFalse())),
				paging);

		long totalItems = paymentRepository.count(payment.reference.containsIgnoreCase(paymentSearchDto.getReference())
				.and(payment.paymentType.eq(paymentSearchDto.getPaymentType()))
				.and(payment.user.id.eq(paymentSearchDto.getUserId()).and(payment.isDeleted.isFalse())));

		ArrayList<Payment> payments = Lists.newArrayList(paymentEntries);

		ArrayList<PaymentDto> paymentDtos = (ArrayList<PaymentDto>) payments.stream()
				.map(entity -> mapper.map(entity, PaymentDto.class)).collect(Collectors.toList());

		ResponseDto<PaymentDto> responseDto = new ResponseDto<>();

		responseDto.setLists(paymentDtos);
		responseDto.setCurrentPage(paymentSearchDto.getCurrentPage());
		responseDto.setTotalItems((int) totalItems);
		responseDto.setTotalPages((int) Math.ceil((float) totalItems / paymentSearchDto.getPageSize()));

		return responseDto;

	}

	@Override
	public ResponseDto<PaymentDto> findPaymentById(PaymentSearchDto paymentSearchDto) {

		Payment payment = paymentRepository.findById(paymentSearchDto.getId()).orElse(null);

		ResponseDto<PaymentDto> responseDto = new ResponseDto<>();
		responseDto.setObject(mapper.map(payment, PaymentDto.class));

		return responseDto;
	}

	@Override
	public ResponseDto<PaymentDto> deletePayment(PaymentDto paymentDto) {

		paymentRepository.deletePayment(paymentDto.getId());

		return new ResponseDto<>();

	}

}
