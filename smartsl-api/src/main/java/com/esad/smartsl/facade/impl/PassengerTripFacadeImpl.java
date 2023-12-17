package com.esad.smartsl.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esad.smartsl.domain.dto.PassengerTripDto;
import com.esad.smartsl.facade.PassengerTripFacade;
import com.esad.smartsl.service.PassengerTripService;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.PassengerTripSearchDto;

@Service
public class PassengerTripFacadeImpl implements PassengerTripFacade {

	@Autowired
	private PassengerTripService passengerTripService;

	@Override
	public ResponseDto<PassengerTripDto> createPassengerTrip(PassengerTripDto passengerTripDto) {
		ResponseDto<PassengerTripDto> responseDto = new ResponseDto<PassengerTripDto>();

		responseDto = passengerTripService.createPassengerTrip(passengerTripDto);

		return responseDto;
	}

	@Override
	public ResponseDto<PassengerTripDto> updatePassengerTrip(PassengerTripDto passengerTripDto) {
		ResponseDto<PassengerTripDto> responseDto = new ResponseDto<PassengerTripDto>();

		responseDto = passengerTripService.updatePassengerTrip(passengerTripDto);

		return responseDto;
	}

	@Override
	public ResponseDto<PassengerTripDto> searchPassengerTrip(PassengerTripSearchDto passengerTripSearchDto)
			throws Exception {
		ResponseDto<PassengerTripDto> responseDto = new ResponseDto<PassengerTripDto>();

		responseDto = passengerTripService.searchPassengerTrip(passengerTripSearchDto);

		return responseDto;
	}

	@Override
	public ResponseDto<PassengerTripDto> findPassengerTripById(PassengerTripSearchDto passengerTripSearchDto) {
		ResponseDto<PassengerTripDto> responseDto = new ResponseDto<PassengerTripDto>();

		responseDto = passengerTripService.findPassengerTripById(passengerTripSearchDto);

		return responseDto;
	}

	@Override
	public ResponseDto<PassengerTripDto> deletePassengerTrip(PassengerTripDto passengerTripDto) {
		ResponseDto<PassengerTripDto> responseDto = new ResponseDto<PassengerTripDto>();

		responseDto = passengerTripService.deletePassengerTrip(passengerTripDto);

		return responseDto;
	}

}
