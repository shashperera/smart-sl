package com.esad.smartsl.service;


import com.esad.smartsl.domain.dto.VehicleDto;
import com.esad.smartsl.dto.responseDto.ResponseDto;

import javax.transaction.Transactional;

@Transactional
public interface VehicleService {
    ResponseDto<VehicleDto> createVehicle(VehicleDto vehicleDto);
}
