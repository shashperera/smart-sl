package com.esad.smartsl.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esad.smartsl.domain.dto.VehicleDto;
import com.esad.smartsl.facade.VehicleFacade;
import com.esad.smartsl.service.VehicleService;
import com.esad.smartsl.dto.responseDto.ResponseDto;

@Service
public class VehicleFacadeImpl implements VehicleFacade {

	@Autowired
	private VehicleService vehicleService;

	@Override
	public ResponseDto<VehicleDto> createVehicle(VehicleDto vehicleDto) {
		ResponseDto<VehicleDto> responseDto = new ResponseDto<VehicleDto>();

		responseDto = vehicleService.createVehicle(vehicleDto);

		return responseDto;
	}

}
