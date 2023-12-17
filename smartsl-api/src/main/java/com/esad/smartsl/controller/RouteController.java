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

import com.esad.smartsl.domain.dto.RouteDto;
import com.esad.smartsl.facade.RouteFacade;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.RouteSearchDto;

@RestController
@RequestMapping("/smartsl")
public class RouteController {

	private static final Logger logger = LoggerFactory.getLogger(RouteController.class);

	@Autowired
	private RouteFacade routeFacade;

	@PostMapping("/create-route")
	public ResponseEntity<ResponseDto<RouteDto>> createRoute(@RequestBody RouteDto routeDto) {

		return new ResponseEntity<>(routeFacade.createRoute(routeDto), HttpStatus.OK);

	}

	@PostMapping("/update-route")
	public ResponseEntity<ResponseDto<RouteDto>> updateRoute(@RequestBody RouteDto routeDto) {

		return new ResponseEntity<>(routeFacade.updateRoute(routeDto), HttpStatus.OK);

	}

	@PostMapping("/search-route")
	public ResponseEntity<ResponseDto<RouteDto>> searchRoute(@RequestBody RouteSearchDto routeSearchDto)
			throws Exception {

		return new ResponseEntity<>(routeFacade.searchRoute(routeSearchDto), HttpStatus.OK);

	}

	@PostMapping("/find-route-by-id")
	public ResponseEntity<ResponseDto<RouteDto>> findRouteById(@RequestBody RouteSearchDto routeSearchDto) {

		return new ResponseEntity<>(routeFacade.findRouteById(routeSearchDto), HttpStatus.OK);

	}

	@PostMapping("/delete-route-by-id")
	public ResponseEntity<ResponseDto<RouteDto>> deleteRoute(@RequestBody RouteDto routeDto) {

		return new ResponseEntity<>(routeFacade.deleteRoute(routeDto), HttpStatus.OK);

	}

}
