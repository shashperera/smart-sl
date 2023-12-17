package com.esad.smartsl.service.impl;

import com.esad.smartsl.domain.dto.VehicleDto;
import com.esad.smartsl.domain.entity.Vehicle;
import com.esad.smartsl.repository.VehicleRepository;
import com.esad.smartsl.service.VehicleService;
import com.esad.smartsl.dto.responseDto.ResponseDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ResponseDto<VehicleDto> createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = mapper.map(vehicleDto, Vehicle.class);
        vehicle = vehicleRepository.save(vehicle);

        ResponseDto<VehicleDto> responseDto = new ResponseDto<>();
        responseDto.setObject(mapper.map(vehicle, VehicleDto.class));

        return responseDto;
    }
}
