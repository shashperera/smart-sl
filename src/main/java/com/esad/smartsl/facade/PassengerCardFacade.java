package com.esad.smartsl.facade;

import javax.transaction.Transactional;

import com.esad.smartsl.domain.dto.PassengerCardDto;
import com.esad.smartsl.dto.requestDto.PassengerCardRequestDto;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.PassengerCardSearchDto;

@Transactional
public interface PassengerCardFacade {

	ResponseDto<PassengerCardDto> createPassengerCard(PassengerCardDto passengerCardDto);

	ResponseDto<PassengerCardDto> updatePassengerCard(PassengerCardDto passengerCardDto);

	ResponseDto<PassengerCardDto> searchPassengerCard(PassengerCardSearchDto passengerCardSearchDto) throws Exception;

	ResponseDto<PassengerCardDto> findPassengerCardById(PassengerCardSearchDto passengerCardSearchDto);

	ResponseDto<PassengerCardDto> deletePassengerCard(PassengerCardDto passengerCardDto);

	ResponseDto<PassengerCardDto> activatePassengerCard(PassengerCardDto passengerCardDto);

	ResponseDto<PassengerCardDto> findPassengerCardByUserEmail(PassengerCardSearchDto passengerCardSearchDto);

	ResponseDto<PassengerCardRequestDto> rechargePassengerCard(PassengerCardRequestDto passengerCardRequestDto);
	ResponseDto<PassengerCardDto> payForTrip(PassengerCardRequestDto passengerTripDto);
}
