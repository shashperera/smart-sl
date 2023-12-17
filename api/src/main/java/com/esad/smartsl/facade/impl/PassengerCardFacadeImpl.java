package com.esad.smartsl.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esad.smartsl.domain.dto.PassengerCardDto;
import com.esad.smartsl.domain.dto.PaymentDto;
import com.esad.smartsl.domain.dto.UserDto;
import com.esad.smartsl.facade.PassengerCardFacade;
import com.esad.smartsl.service.PassengerCardService;
import com.esad.smartsl.service.PaymentService;
import com.esad.smartsl.service.UserService;
import com.esad.smartsl.dto.requestDto.PassengerCardRequestDto;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.PassengerCardSearchDto;
import com.esad.smartsl.dto.searchDto.UserSearchDto;
import com.esad.smartsl.enums.ResponseMessage;

@Service
public class PassengerCardFacadeImpl implements PassengerCardFacade {

	@Autowired
	private PassengerCardService passengerCardService;

	@Autowired
	private UserService userService;

	@Autowired
	private PaymentService paymentService;

	@Override
	public ResponseDto<PassengerCardDto> createPassengerCard(PassengerCardDto passengerCardDto) {

		ResponseDto<PassengerCardDto> responseDto = new ResponseDto<PassengerCardDto>();

		responseDto = passengerCardService.createPassengerCard(passengerCardDto);

		return responseDto;

	}

	@Override
	public ResponseDto<PassengerCardDto> updatePassengerCard(PassengerCardDto passengerCardDto) {

		ResponseDto<PassengerCardDto> responseDto = new ResponseDto<PassengerCardDto>();

		responseDto = passengerCardService.updatePassengerCard(passengerCardDto);

		return responseDto;

	}

	@Override
	public ResponseDto<PassengerCardDto> searchPassengerCard(PassengerCardSearchDto passengerCardSearchDto)
			throws Exception {
		ResponseDto<PassengerCardDto> responseDto = new ResponseDto<PassengerCardDto>();

		responseDto = passengerCardService.searchPassengerCard(passengerCardSearchDto);

		return responseDto;
	}

	@Override
	public ResponseDto<PassengerCardDto> findPassengerCardById(PassengerCardSearchDto passengerCardSearchDto) {
		ResponseDto<PassengerCardDto> responseDto = new ResponseDto<PassengerCardDto>();

		responseDto = passengerCardService.findPassengerCardById(passengerCardSearchDto);

		return responseDto;
	}

	@Override
	public ResponseDto<PassengerCardDto> deletePassengerCard(PassengerCardDto passengerCardDto) {
		ResponseDto<PassengerCardDto> responseDto = new ResponseDto<PassengerCardDto>();

		responseDto = passengerCardService.deletePassengerCard(passengerCardDto);

		return responseDto;
	}

	@Override
	public ResponseDto<PassengerCardDto> activatePassengerCard(PassengerCardDto passengerCardDto) {

		ResponseDto<PassengerCardDto> responseDto = new ResponseDto<PassengerCardDto>();

		responseDto = passengerCardService.activatePassengerCard(passengerCardDto);

		return responseDto;
	}

	@Override
	public ResponseDto<PassengerCardDto> findPassengerCardByUserEmail(PassengerCardSearchDto passengerCardSearchDto) {

		ResponseDto<PassengerCardDto> responseDto = new ResponseDto<PassengerCardDto>();

		UserSearchDto userSearchDto = new UserSearchDto();

		userSearchDto.setEmail(passengerCardSearchDto.getEmail());

		ResponseDto<UserDto> responseUserDto = userService.findUserByEmail(userSearchDto);

		if (responseUserDto.getObject() != null) {

			UserDto userDto = responseUserDto.getObject();

			passengerCardSearchDto.setUserId(userDto.getId());

			responseDto = passengerCardService.findPassengerCardByUserEmail(passengerCardSearchDto);

		}

		return responseDto;
	}

	@Override
	public ResponseDto<PassengerCardRequestDto> rechargePassengerCard(PassengerCardRequestDto passengerCardRequestDto) {

		ResponseDto<PassengerCardRequestDto> responseDto = new ResponseDto<PassengerCardRequestDto>();

//		create payment record
		ResponseDto<PaymentDto> responsePaymentDto = paymentService
				.createPayment(passengerCardRequestDto.getPaymentDto());

//		if payment successfully created
		if (responsePaymentDto.getObject() != null) {

//			setting payment record to passenger card dto
			PassengerCardDto passengerCardDto = passengerCardRequestDto.getPassengerCardDto();

			passengerCardDto.setPayment(responsePaymentDto.getObject());
			passengerCardDto.setPaymentStatus(1);

			ResponseDto<PassengerCardDto> responsePassengerCardDto = passengerCardService
					.rechargePassengerCard(passengerCardDto);

			passengerCardRequestDto.setPassengerCardDto(responsePassengerCardDto.getObject());
			passengerCardRequestDto.setPaymentDto(responsePaymentDto.getObject());

			responseDto.setObject(passengerCardRequestDto);
			responseDto.setMessage(ResponseMessage.SUCCESS);

		}

		return responseDto;
	}

	@Override
	public ResponseDto<PassengerCardDto> payForTrip(PassengerCardRequestDto passengerTripDto) {

	}

}
