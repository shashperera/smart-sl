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

import com.esad.smartsl.domain.dto.PassengerTripDto;
import com.esad.smartsl.facade.PassengerTripFacade;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.PassengerTripSearchDto;

@RestController
@RequestMapping("/smartsl")
public class PassengerTripController {

	private static final Logger logger = LoggerFactory.getLogger(PassengerTripController.class);

	@Autowired
	private PassengerTripFacade passengerTripFacade;

	@PostMapping("/create-passenger-trip")
	public ResponseEntity<ResponseDto<PassengerTripDto>> createPassengerTrip(
			@RequestBody PassengerTripDto passengerTripDto) {

		return new ResponseEntity<>(passengerTripFacade.createPassengerTrip(passengerTripDto), HttpStatus.OK);

	}

	@PostMapping("/update-passenger-trip")
	public ResponseEntity<ResponseDto<PassengerTripDto>> updatePassengerTrip(
			@RequestBody PassengerTripDto passengerTripDto) {

		return new ResponseEntity<>(passengerTripFacade.updatePassengerTrip(passengerTripDto), HttpStatus.OK);

	}

	@PostMapping("/search-passenger-trip")
	public ResponseEntity<ResponseDto<PassengerTripDto>> searchPassengerTrip(
			@RequestBody PassengerTripSearchDto passengerTripSearchDto) throws Exception {

		return new ResponseEntity<>(passengerTripFacade.searchPassengerTrip(passengerTripSearchDto), HttpStatus.OK);

	}

	@PostMapping("/find-passenger-trip-by-id")
	public ResponseEntity<ResponseDto<PassengerTripDto>> findPassengerTripById(
			@RequestBody PassengerTripSearchDto passengerTripSearchDto) {

		return new ResponseEntity<>(passengerTripFacade.findPassengerTripById(passengerTripSearchDto), HttpStatus.OK);

	}

	@PostMapping("/delete-passenger-trip")
	public ResponseEntity<ResponseDto<PassengerTripDto>> deletePassengerTrip(
			@RequestBody PassengerTripDto passengerTripDto) {

		return new ResponseEntity<>(passengerTripFacade.deletePassengerTrip(passengerTripDto), HttpStatus.OK);

	}
}
