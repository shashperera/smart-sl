package com.esad.smartsl.facade;

import javax.transaction.Transactional;

import com.esad.smartsl.domain.dto.RouteDto;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.RouteSearchDto;

@Transactional
public interface RouteFacade {

	ResponseDto<RouteDto> createRoute(RouteDto routeDto);

	ResponseDto<RouteDto> updateRoute(RouteDto routeDto);

	ResponseDto<RouteDto> searchRoute(RouteSearchDto routeSearchDto) throws Exception;

	ResponseDto<RouteDto> findRouteById(RouteSearchDto routeSearchDto);

	ResponseDto<RouteDto> deleteRoute(RouteDto routeDto);

}
