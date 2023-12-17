package com.esad.smartsl.facade;

import javax.transaction.Transactional;

import com.esad.smartsl.domain.dto.PassengerTripDto;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.PassengerTripSearchDto;

@Transactional
public interface PassengerTripFacade {

	ResponseDto<PassengerTripDto> createPassengerTrip(PassengerTripDto passengerTripDto);

	ResponseDto<PassengerTripDto> updatePassengerTrip(PassengerTripDto passengerTripDto);

	ResponseDto<PassengerTripDto> searchPassengerTrip(PassengerTripSearchDto passengerTripSearchDto) throws Exception;

	ResponseDto<PassengerTripDto> findPassengerTripById(PassengerTripSearchDto passengerTripSearchDto);

	ResponseDto<PassengerTripDto> deletePassengerTrip(PassengerTripDto passengerTripDto);
}
