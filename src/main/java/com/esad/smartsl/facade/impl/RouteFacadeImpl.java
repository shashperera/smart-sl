package com.esad.smartsl.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esad.smartsl.domain.dto.RouteDto;
import com.esad.smartsl.facade.RouteFacade;
import com.esad.smartsl.service.RouteService;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.RouteSearchDto;

@Service
public class RouteFacadeImpl implements RouteFacade {

	@Autowired
	private RouteService routeService;

	@Override
	public ResponseDto<RouteDto> createRoute(RouteDto routeDto) {
		ResponseDto<RouteDto> responseDto = new ResponseDto<RouteDto>();

		responseDto = routeService.createRoute(routeDto);

		return responseDto;
	}

	@Override
	public ResponseDto<RouteDto> updateRoute(RouteDto routeDto) {
		ResponseDto<RouteDto> responseDto = new ResponseDto<RouteDto>();

		responseDto = routeService.updateRoute(routeDto);

		return responseDto;
	}

	@Override
	public ResponseDto<RouteDto> searchRoute(RouteSearchDto routeSearchDto) throws Exception {
		ResponseDto<RouteDto> responseDto = new ResponseDto<RouteDto>();

		responseDto = routeService.searchRoute(routeSearchDto);

		return responseDto;
	}

	@Override
	public ResponseDto<RouteDto> findRouteById(RouteSearchDto routeSearchDto) {
		ResponseDto<RouteDto> responseDto = new ResponseDto<RouteDto>();

		responseDto = routeService.findRouteById(routeSearchDto);

		return responseDto;
	}

	@Override
	public ResponseDto<RouteDto> deleteRoute(RouteDto routeDto) {
		ResponseDto<RouteDto> responseDto = new ResponseDto<RouteDto>();

		responseDto = routeService.deleteRoute(routeDto);

		return responseDto;
	}

}
