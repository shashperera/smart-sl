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

import com.esad.smartsl.domain.dto.PassengerTripDto;
import com.esad.smartsl.domain.entity.PassengerTrip;
import com.esad.smartsl.domain.entity.QPassengerTrip;
import com.esad.smartsl.repository.PassengerTripRepository;
import com.esad.smartsl.service.PassengerTripService;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.PassengerTripSearchDto;
import com.esad.smartsl.enums.OrderDirection;
import com.google.common.collect.Lists;

@Service
public class PassengerTripServiceImpl implements PassengerTripService {

	private static final Logger logger = LoggerFactory.getLogger(PassengerTripServiceImpl.class);

	@Autowired
	private PassengerTripRepository passengerTripRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ResponseDto<PassengerTripDto> createPassengerTrip(PassengerTripDto passengerTripDto) {

		// get the current date and time
		Date today = new Date();

		passengerTripDto.setCreatedAt(new Timestamp(today.getTime()));

		PassengerTrip passengerTrip = mapper.map(passengerTripDto, PassengerTrip.class);

		passengerTrip = passengerTripRepository.save(passengerTrip);

		ResponseDto<PassengerTripDto> responseDto = new ResponseDto<>();
		responseDto.setObject(mapper.map(passengerTrip, PassengerTripDto.class));

		return responseDto;
	}

	@Override
	public ResponseDto<PassengerTripDto> updatePassengerTrip(PassengerTripDto passengerTripDto) {

		PassengerTrip passengerTrip = passengerTripRepository.findById(passengerTripDto.getId()).orElse(null);

		if (passengerTrip != null) {

			passengerTrip.setEndLocation(passengerTripDto.getEndLocation());
			passengerTrip.setEndDatetime(passengerTripDto.getEndDatetime());
			passengerTrip.setStatus(passengerTripDto.getStatus());
			passengerTrip.setDistance(passengerTripDto.getDistance());
			passengerTrip.setDuration(passengerTripDto.getDuration());
			passengerTrip.setStar(passengerTripDto.getStar());
			passengerTrip.setComment(passengerTripDto.getComment());
			passengerTrip.setPaymentStatus(passengerTripDto.getPaymentStatus());
			passengerTrip.setFare(passengerTripDto.getFare());

			// getting current date and time
			Date today = new Date();

			passengerTrip.setUpdatedAt(new Timestamp(today.getTime()));
			passengerTrip.setUpdatedBy(passengerTripDto.getUpdatedBy());

			passengerTrip = passengerTripRepository.save(passengerTrip);

			passengerTripDto = mapper.map(passengerTrip, PassengerTripDto.class);

		}

		ResponseDto<PassengerTripDto> responseDto = new ResponseDto<>();
		responseDto.setObject(passengerTripDto);

		return responseDto;

	}

//	@Override
	public ResponseDto<PassengerTripDto> searchPassengerTrip(PassengerTripSearchDto passengerTripSearchDto)
			throws Exception {

		QPassengerTrip passengerTrip = QPassengerTrip.passengerTrip;

		// setting pagination
		Pageable paging = PageRequest.of(passengerTripSearchDto.getCurrentPage(), passengerTripSearchDto.getPageSize(),
				passengerTripSearchDto.getOrderDirection() == OrderDirection.ASC
						? Sort.by(passengerTripSearchDto.getSortBy()).ascending()
						: Sort.by(passengerTripSearchDto.getSortBy()).descending());

		Iterable<PassengerTrip> passengerTripEntries = passengerTripRepository
				.findAll(passengerTrip.reference.containsIgnoreCase(passengerTripSearchDto.getReference())
						.and(passengerTrip.startLocation.containsIgnoreCase(passengerTripSearchDto.getStartLocation()))
						.and(passengerTrip.endLocation.containsIgnoreCase(passengerTripSearchDto.getEndLocation()))
						.and(passengerTrip.passenger.id.eq(passengerTripSearchDto.getPassengerId())
								.and(passengerTrip.isDeleted.isFalse())),
						paging);

		long totalItems = passengerTripRepository
				.count(passengerTrip.reference.containsIgnoreCase(passengerTripSearchDto.getReference())
						.and(passengerTrip.startLocation.containsIgnoreCase(passengerTripSearchDto.getStartLocation()))
						.and(passengerTrip.endLocation.containsIgnoreCase(passengerTripSearchDto.getEndLocation()))
						.and(passengerTrip.passenger.id.eq(passengerTripSearchDto.getPassengerId())
								.and(passengerTrip.isDeleted.isFalse())));

		ArrayList<PassengerTrip> passengerTrips = Lists.newArrayList(passengerTripEntries);

		ArrayList<PassengerTripDto> passengerTripDtos = (ArrayList<PassengerTripDto>) passengerTrips.stream()
				.map(entity -> mapper.map(entity, PassengerTripDto.class)).collect(Collectors.toList());

		ResponseDto<PassengerTripDto> responseDto = new ResponseDto<>();

		responseDto.setLists(passengerTripDtos);
		responseDto.setCurrentPage(passengerTripSearchDto.getCurrentPage());
		responseDto.setTotalItems((int) totalItems);
		responseDto.setTotalPages((int) Math.ceil((float) totalItems / passengerTripSearchDto.getPageSize()));

		return responseDto;

	}

	@Override
	public ResponseDto<PassengerTripDto> findPassengerTripById(PassengerTripSearchDto passengerTripSearchDto) {

		PassengerTrip passengerTrip = passengerTripRepository.findById(passengerTripSearchDto.getId()).orElse(null);

		ResponseDto<PassengerTripDto> responseDto = new ResponseDto<>();
		responseDto.setObject(mapper.map(passengerTrip, PassengerTripDto.class));

		return responseDto;
	}

	@Override
	public ResponseDto<PassengerTripDto> deletePassengerTrip(PassengerTripDto passengerTripDto) {

		passengerTripRepository.deletePassengerTrip(passengerTripDto.getId());

		return new ResponseDto<>();

	}

}
