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

import com.esad.smartsl.domain.dto.TimetableDto;
import com.esad.smartsl.domain.entity.QTimetable;
import com.esad.smartsl.domain.entity.Route;
import com.esad.smartsl.domain.entity.Timetable;
import com.esad.smartsl.domain.entity.User;
import com.esad.smartsl.domain.entity.Vehicle;
import com.esad.smartsl.repository.TimetableRepository;
import com.esad.smartsl.service.TimetableService;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.TimetableSearchDto;
import com.google.common.collect.Lists;

@Service
public class TimetableServiceImpl implements TimetableService {

	private static final Logger logger = LoggerFactory.getLogger(TimetableServiceImpl.class);

	@Autowired
	private TimetableRepository timetableRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ResponseDto<TimetableDto> createTimetable(TimetableDto timetableDto) {

		// get the current date and time
		Date today = new Date();

		timetableDto.setCreatedAt(new Timestamp(today.getTime()));

		Timetable timetable = mapper.map(timetableDto, Timetable.class);

		timetable = timetableRepository.save(timetable);

		ResponseDto<TimetableDto> responseDto = new ResponseDto<>();
		responseDto.setObject(mapper.map(timetable, TimetableDto.class));

		return responseDto;
	}

	@Override
	public ResponseDto<TimetableDto> updateTimetable(TimetableDto timetableDto) {

		Timetable timetable = timetableRepository.findById(timetableDto.getId()).orElse(null);

		if (timetable != null) {

			timetable.setStartTime(timetableDto.getStartTime());
			timetable.setEndTime(timetableDto.getEndTime());
			timetable.setReference(timetableDto.getReference());

			Route route = new Route();
			route.setId(timetableDto.getRoute().getId());

			timetable.setRoute(route);

			User user = new User();
			user.setId(timetableDto.getUser().getId());

			timetable.setUser(user);

			Vehicle vehicle = new Vehicle();
			vehicle.setId(timetableDto.getVehicle().getId());

			timetable.setVehicle(vehicle);

			// getting current date and time
			Date today = new Date();

			timetable.setUpdatedAt(new Timestamp(today.getTime()));
			timetable.setUpdatedBy(timetableDto.getUpdatedBy());

			timetable = timetableRepository.save(timetable);

			timetableDto = mapper.map(timetable, TimetableDto.class);

		}

		ResponseDto<TimetableDto> responseDto = new ResponseDto<>();
		responseDto.setObject(timetableDto);

		return responseDto;

	}

	@Override
	public ResponseDto<TimetableDto> searchTimetable(TimetableSearchDto timetableSearchDto) throws Exception {

		QTimetable timetable = QTimetable.timetable;

		// setting pagination
		Pageable paging = PageRequest.of(timetableSearchDto.getCurrentPage(), timetableSearchDto.getPageSize(),
				Sort.by(timetableSearchDto.getSortBy()));

		Iterable<Timetable> timetableEntries = timetableRepository.findAll(
				timetable.startTime.between(timetableSearchDto.getStartTime(), timetableSearchDto.getEndTime())
						.and(timetable.user.id.eq(timetableSearchDto.getUserId()))
						.and(timetable.vehicle.id.eq(timetableSearchDto.getVehicleId()))
						.and(timetable.route.id.eq(timetableSearchDto.getRouteId())).and(timetable.isDeleted.isFalse()),
				paging);

		long totalItems = timetableRepository.count(timetable.startTime
				.between(timetableSearchDto.getStartTime(), timetableSearchDto.getEndTime())
				.and(timetable.user.id.eq(timetableSearchDto.getUserId()))
				.and(timetable.vehicle.id.eq(timetableSearchDto.getVehicleId()))
				.and(timetable.route.id.eq(timetableSearchDto.getRouteId())).and(timetable.isDeleted.isFalse()));

		ArrayList<Timetable> timetables = Lists.newArrayList(timetableEntries);

		ArrayList<TimetableDto> timetableDtos = (ArrayList<TimetableDto>) timetables.stream()
				.map(entity -> mapper.map(entity, TimetableDto.class)).collect(Collectors.toList());

		ResponseDto<TimetableDto> responseDto = new ResponseDto<>();

		responseDto.setLists(timetableDtos);
		responseDto.setCurrentPage(timetableSearchDto.getCurrentPage());
		responseDto.setTotalItems((int) totalItems);
		responseDto.setTotalPages((int) Math.ceil((float) totalItems / timetableSearchDto.getPageSize()));

		return responseDto;

	}

	@Override
	public ResponseDto<TimetableDto> findTimetableById(TimetableSearchDto timetableSearchDto) {

		Timetable timetableEntry = timetableRepository.findById(timetableSearchDto.getId()).orElse(null);

		ResponseDto<TimetableDto> responseDto = new ResponseDto<>();
		responseDto.setObject(mapper.map(timetableEntry, TimetableDto.class));

		return responseDto;
	}

	@Override
	public ResponseDto<TimetableDto> deleteTimetable(TimetableDto timetableDto) {

		timetableRepository.deleteTimetable(timetableDto.getId());

		return new ResponseDto<>();

	}

}
