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

import com.esad.smartsl.domain.dto.VehicleDto;
import com.esad.smartsl.facade.VehicleFacade;
import com.esad.smartsl.dto.responseDto.ResponseDto;

@RestController
@RequestMapping("/smartsl")
public class VehicleController {

	private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);

	@Autowired
	private VehicleFacade vehicleFacade;

	@PostMapping("/create-vehicle")
	public ResponseEntity<ResponseDto<VehicleDto>> createUser(@RequestBody VehicleDto vehicleDto) {

		return new ResponseEntity<>(vehicleFacade.createVehicle(vehicleDto), HttpStatus.OK);

	}

}
