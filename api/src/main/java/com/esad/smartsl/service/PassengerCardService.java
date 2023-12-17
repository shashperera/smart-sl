package com.esad.smartsl.service;

import org.springframework.transaction.annotation.Transactional;

import com.esad.smartsl.domain.dto.PassengerCardDto;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.PassengerCardSearchDto;

@Transactional
public interface PassengerCardService {

	ResponseDto<PassengerCardDto> createPassengerCard(PassengerCardDto passengerCardDto);

	ResponseDto<PassengerCardDto> updatePassengerCard(PassengerCardDto passengerCardDto);

	ResponseDto<PassengerCardDto> searchPassengerCard(PassengerCardSearchDto passengerCardSearchDto) throws Exception;

	ResponseDto<PassengerCardDto> findPassengerCardById(PassengerCardSearchDto passengerCardSearchDto);

	ResponseDto<PassengerCardDto> deletePassengerCard(PassengerCardDto passengerCardDto);

	ResponseDto<PassengerCardDto> activatePassengerCard(PassengerCardDto passengerCardDto);

	ResponseDto<PassengerCardDto> findPassengerCardByUserEmail(PassengerCardSearchDto passengerCardSearchDto);

	ResponseDto<PassengerCardDto> rechargePassengerCard(PassengerCardDto passengerCardDto);

}
