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

import com.esad.smartsl.domain.dto.PassengerCardDto;
import com.esad.smartsl.facade.PassengerCardFacade;
import com.esad.smartsl.dto.requestDto.PassengerCardRequestDto;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.PassengerCardSearchDto;

@RestController
@RequestMapping("/smartsl")
public class PassengerCardController {

	private static final Logger logger = LoggerFactory.getLogger(PassengerCardController.class);

	@Autowired
	private PassengerCardFacade passengerCardFacade;

	@PostMapping("/create-passenger-card")
	public ResponseEntity<ResponseDto<PassengerCardDto>> createPassengerCard(
			@RequestBody PassengerCardDto passengerCardDto) {

		return new ResponseEntity<>(passengerCardFacade.createPassengerCard(passengerCardDto), HttpStatus.OK);

	}

	@PostMapping("/update-passenger-card")
	public ResponseEntity<ResponseDto<PassengerCardDto>> updatePassengerCard(
			@RequestBody PassengerCardDto passengerCardDto) {

		return new ResponseEntity<>(passengerCardFacade.updatePassengerCard(passengerCardDto), HttpStatus.OK);

	}

	@PostMapping("/search-passenger-card")
	public ResponseEntity<ResponseDto<PassengerCardDto>> searchPassengerCard(
			@RequestBody PassengerCardSearchDto passengerCardSearchDto) throws Exception {

		return new ResponseEntity<>(passengerCardFacade.searchPassengerCard(passengerCardSearchDto), HttpStatus.OK);

	}

	@PostMapping("/find-passenger-card-by-id")
	public ResponseEntity<ResponseDto<PassengerCardDto>> findPassengerCardById(
			@RequestBody PassengerCardSearchDto passengerCardSearchDto) {

		return new ResponseEntity<>(passengerCardFacade.findPassengerCardById(passengerCardSearchDto), HttpStatus.OK);

	}

	@PostMapping("/delete-passenger-card")
	public ResponseEntity<ResponseDto<PassengerCardDto>> deletePassengerCard(
			@RequestBody PassengerCardDto passengerCardDto) {

		return new ResponseEntity<>(passengerCardFacade.deletePassengerCard(passengerCardDto), HttpStatus.OK);

	}

	@PostMapping("/activate-passenger-card")
	public ResponseEntity<ResponseDto<PassengerCardDto>> activatePassengerCard(
			@RequestBody PassengerCardDto passengerCardDto) {

		return new ResponseEntity<>(passengerCardFacade.activatePassengerCard(passengerCardDto), HttpStatus.OK);

	}

	@PostMapping("/find-passenger-card-by-email")
	public ResponseEntity<ResponseDto<PassengerCardDto>> findPassengerCardByUserEmail(
			@RequestBody PassengerCardSearchDto passengerCardSearchDto) {

		return new ResponseEntity<>(passengerCardFacade.findPassengerCardByUserEmail(passengerCardSearchDto),
				HttpStatus.OK);

	}

	@PostMapping("/recharge-passenger-card")
	public ResponseEntity<ResponseDto<PassengerCardRequestDto>> rechargePassengerCard(
			@RequestBody PassengerCardRequestDto passengerCardRequestDto) {

		return new ResponseEntity<>(passengerCardFacade.rechargePassengerCard(passengerCardRequestDto), HttpStatus.OK);

	}

	@PostMapping("/pay-for-trip")
	public ResponseEntity<ResponseDto<PassengerCardDto>> payForTrip(
			@RequestBody PassengerCardRequestDto passengerCardRequestDto)
	{
		return new ResponseEntity<>(passengerCardFacade.payForTrip(passengerCardRequestDto), HttpStatus.OK);
	}

}
