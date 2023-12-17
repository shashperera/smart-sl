package com.esad.smartsl.facade;

import javax.transaction.Transactional;

import com.esad.smartsl.domain.dto.VehicleDto;
import com.esad.smartsl.dto.responseDto.ResponseDto;

@Transactional
public interface VehicleFacade {
	ResponseDto<VehicleDto> createVehicle(VehicleDto vehicleDto);
}
