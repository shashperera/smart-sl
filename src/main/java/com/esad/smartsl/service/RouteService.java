package com.esad.smartsl.service;

import com.esad.smartsl.domain.dto.RouteDto;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.RouteSearchDto;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RouteService {

	ResponseDto<RouteDto> createRoute(RouteDto routeDto);

	ResponseDto<RouteDto> updateRoute(RouteDto routeDto);

	ResponseDto<RouteDto> searchRoute(RouteSearchDto routeSearchDto);

	ResponseDto<RouteDto> findRouteById(RouteSearchDto routeSearchDto);

	ResponseDto<RouteDto> deleteRoute(RouteDto routeDto);

}
