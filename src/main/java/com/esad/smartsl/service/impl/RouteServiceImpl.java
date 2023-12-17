package com.esad.smartsl.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.esad.smartsl.domain.dto.RouteDto;
import com.esad.smartsl.domain.entity.QRoute;
import com.esad.smartsl.domain.entity.Route;
import com.esad.smartsl.repository.RouteRepository;
import com.esad.smartsl.service.RouteService;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.RouteSearchDto;
import com.esad.smartsl.enums.OrderDirection;
import com.google.common.collect.Lists;

@Service
public class RouteServiceImpl implements RouteService {

	private static final Logger logger = LoggerFactory.getLogger(RouteServiceImpl.class);

	@Autowired
	private RouteRepository routeRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ResponseDto<RouteDto> createRoute(RouteDto routerDto) {

		// get the current date and time
		Date today = new Date();

		routerDto.setCreatedAt(new Timestamp(today.getTime()));

		Route route = mapper.map(routerDto, Route.class);

		route = routeRepository.save(route);

		ResponseDto<RouteDto> responseDto = new ResponseDto<>();
		responseDto.setObject(mapper.map(route, RouteDto.class));

		return responseDto;
	}

	@Override
	public ResponseDto<RouteDto> updateRoute(RouteDto routeDto) {

		Route route = routeRepository.findById(routeDto.getId()).orElse(null);

		if (route != null) {

			route.setName(routeDto.getName());
			route.setCode(routeDto.getCode());
			route.setStartLocation(routeDto.getStartLocation());
			route.setEndLocation(routeDto.getEndLocation());
			route.setDistance(routeDto.getDistance());
			route.setMaximumCost(routeDto.getMaximumCost());
			route.setMinimumCost(routeDto.getMinimumCost());
			route.setDuration(routeDto.getDuration());
			route.setFairRate(routeDto.getFairRate());
			route.setMinimumDistance(routeDto.getMinimumDistance());

			// getting current date and time
			Date today = new Date();

			route.setUpdatedAt(new Timestamp(today.getTime()));
			route.setUpdatedBy(routeDto.getUpdatedBy());

			route = routeRepository.save(route);

			routeDto = mapper.map(route, RouteDto.class);

		}

		ResponseDto<RouteDto> responseDto = new ResponseDto<>();
		responseDto.setObject(routeDto);

		return responseDto;

	}

	@Override
	public ResponseDto<RouteDto> searchRoute(RouteSearchDto routeSearchDto) {

		QRoute route = QRoute.route;

		// setting pagination
		Pageable paging = PageRequest.of(routeSearchDto.getCurrentPage(), routeSearchDto.getPageSize(),
				routeSearchDto.getOrderDirection() == OrderDirection.ASC
						? Sort.by(routeSearchDto.getSortBy()).ascending()
						: Sort.by(routeSearchDto.getSortBy()).descending());

		Iterable<Route> routeEntries = routeRepository.findAll(
				route.name.containsIgnoreCase(routeSearchDto.getName())
						.and(route.code.containsIgnoreCase(routeSearchDto.getCode()).and(route.isDeleted.isFalse())),
				paging);

		long totalItems = routeRepository.count(route.name.containsIgnoreCase(routeSearchDto.getName())
				.and(route.code.containsIgnoreCase(routeSearchDto.getCode()).and(route.isDeleted.isFalse())));

		ArrayList<Route> routes = Lists.newArrayList(routeEntries);

		ArrayList<RouteDto> routeDtos = (ArrayList<RouteDto>) routes.stream()
				.map(entity -> mapper.map(entity, RouteDto.class)).collect(Collectors.toList());

		ResponseDto<RouteDto> responseDto = new ResponseDto<>();

		responseDto.setLists(routeDtos);
		responseDto.setCurrentPage(routeSearchDto.getCurrentPage());
		responseDto.setTotalItems((int) totalItems);
		responseDto.setTotalPages((int) Math.ceil((float) totalItems / routeSearchDto.getPageSize()));

		return responseDto;

	}

	@Override
	public ResponseDto<RouteDto> findRouteById(RouteSearchDto routeSearchDto) {

		Route route = routeRepository.findById(routeSearchDto.getId()).orElse(null);

		ResponseDto<RouteDto> responseDto = new ResponseDto<>();
		responseDto.setObject(mapper.map(route, RouteDto.class));

		return responseDto;
	}

	@Override
	public ResponseDto<RouteDto> deleteRoute(RouteDto routeDto) {

		routeRepository.deleteRoute(routeDto.getId());

		return new ResponseDto<>();

	}

}
