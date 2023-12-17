package com.esad.smartsl.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.esad.smartsl.domain.dto.PassengerCardDto;
import com.esad.smartsl.domain.entity.CardPackage;
import com.esad.smartsl.domain.entity.PassengerCard;
import com.esad.smartsl.domain.entity.QPassengerCard;
import com.esad.smartsl.repository.PassengerCardRepository;
import com.esad.smartsl.repository.UserRepository;
import com.esad.smartsl.service.PassengerCardService;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.PassengerCardSearchDto;
import com.esad.smartsl.enums.OrderDirection;
import com.esad.smartsl.enums.ResponseMessage;
import com.google.common.collect.Lists;

@Service
public class PassengerCardServiceImpl implements PassengerCardService {

	private static final Logger logger = LoggerFactory.getLogger(PassengerCardServiceImpl.class);

	@Autowired
	private PassengerCardRepository passengerCardRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ResponseDto<PassengerCardDto> createPassengerCard(PassengerCardDto passengerCardDto) {

		// get the current date and time
		Date today = new Date();

		passengerCardDto.setCreatedAt(new Timestamp(today.getTime()));

		PassengerCard passengerCard = mapper.map(passengerCardDto, PassengerCard.class);

		passengerCard = passengerCardRepository.save(passengerCard);

		ResponseDto<PassengerCardDto> responseDto = new ResponseDto<>();
		responseDto.setObject(mapper.map(passengerCard, PassengerCardDto.class));

		return responseDto;
	}

	@Override
	public ResponseDto<PassengerCardDto> updatePassengerCard(PassengerCardDto passengerCardDto) {

		PassengerCard passengerCard = passengerCardRepository.findById(passengerCardDto.getId()).orElse(null);

		if (passengerCard != null) {

			passengerCard.setReference(passengerCardDto.getReference());
			passengerCard.setPaymentStatus(passengerCardDto.getPaymentStatus());
			passengerCard.setTotalUsage(passengerCardDto.getTotalUsage());
			passengerCard.setStatus(passengerCardDto.getStatus());
			passengerCard.setCardAmount(passengerCardDto.getCardAmount());

			CardPackage cardPackage = new CardPackage();
			cardPackage.setId(passengerCardDto.getCardPackage().getId());

			// getting current date and time
			Date today = new Date();

			passengerCard.setUpdatedAt(new Timestamp(today.getTime()));
			passengerCard.setUpdatedBy(passengerCardDto.getUpdatedBy());

			passengerCard = passengerCardRepository.save(passengerCard);

			passengerCardDto = mapper.map(passengerCard, PassengerCardDto.class);

		}

		ResponseDto<PassengerCardDto> responseDto = new ResponseDto<>();
		responseDto.setObject(passengerCardDto);

		return responseDto;

	}

	@Override
	public ResponseDto<PassengerCardDto> searchPassengerCard(PassengerCardSearchDto passengerCardSearchDto)
			throws Exception {
//
		QPassengerCard passengerCard = QPassengerCard.passengerCard;

		// setting pagination
		Pageable paging = PageRequest.of(passengerCardSearchDto.getCurrentPage(), passengerCardSearchDto.getPageSize(),
				passengerCardSearchDto.getOrderDirection() == OrderDirection.ASC
						? Sort.by(passengerCardSearchDto.getSortBy()).ascending()
						: Sort.by(passengerCardSearchDto.getSortBy()).descending());

		Iterable<PassengerCard> passengerCardEntries = passengerCardRepository
				.findAll(passengerCard.reference.containsIgnoreCase(passengerCardSearchDto.getReference())
						.and(passengerCard.paymentStatus.eq(passengerCardSearchDto.getPaymentStatus()))
						.and(passengerCard.cardPackage.id.eq(passengerCardSearchDto.getCardPackageId()))
						.and(passengerCard.user.id.eq(passengerCardSearchDto.getUserId())
								.and(passengerCard.isDeleted.isFalse())),
						paging);

		long totalItems = passengerCardRepository
				.count(passengerCard.reference.containsIgnoreCase(passengerCardSearchDto.getReference())
						.and(passengerCard.paymentStatus.eq(passengerCardSearchDto.getPaymentStatus()))
						.and(passengerCard.cardPackage.id.eq(passengerCardSearchDto.getCardPackageId()))
						.and(passengerCard.user.id.eq(passengerCardSearchDto.getUserId())
								.and(passengerCard.isDeleted.isFalse())));

		ArrayList<PassengerCard> passengerCards = Lists.newArrayList(passengerCardEntries);

		ArrayList<PassengerCardDto> passengerCardDtos = (ArrayList<PassengerCardDto>) passengerCards.stream()
				.map(entity -> mapper.map(entity, PassengerCardDto.class)).collect(Collectors.toList());

		ResponseDto<PassengerCardDto> responseDto = new ResponseDto<>();

		responseDto.setLists(passengerCardDtos);
		responseDto.setCurrentPage(passengerCardSearchDto.getCurrentPage());
		responseDto.setTotalItems((int) totalItems);
		responseDto.setTotalPages((int) Math.ceil((float) totalItems / passengerCardSearchDto.getPageSize()));

		return responseDto;

	}

	@Override
	public ResponseDto<PassengerCardDto> findPassengerCardById(PassengerCardSearchDto passengerCardSearchDto) {

		PassengerCard passengerCard = passengerCardRepository.findById(passengerCardSearchDto.getId()).orElse(null);

		ResponseDto<PassengerCardDto> responseDto = new ResponseDto<>();
		responseDto.setObject(mapper.map(passengerCard, PassengerCardDto.class));

		return responseDto;
	}

	@Override
	public ResponseDto<PassengerCardDto> deletePassengerCard(PassengerCardDto passengerCardDto) {

		passengerCardRepository.deletePassengerCard(passengerCardDto.getId());

		return new ResponseDto<PassengerCardDto>();

	}

	@Override
	public ResponseDto<PassengerCardDto> activatePassengerCard(PassengerCardDto passengerCardDto) {

		ResponseDto<PassengerCardDto> responseDto = new ResponseDto<PassengerCardDto>();

		PassengerCard passengerCard = passengerCardRepository
				.searchPassengerCardByPhoneNo(passengerCardDto.getReference());

		if (passengerCard != null) {

			passengerCardRepository.activatePassengerCard(passengerCard.getId());
			responseDto.setMessage(ResponseMessage.SUCCESS);

		} else {
			responseDto.setMessage(ResponseMessage.NOT_EXIST);
		}

		return responseDto;

	}

	@Override
	public ResponseDto<PassengerCardDto> findPassengerCardByUserEmail(PassengerCardSearchDto passengerCardSearchDto) {

		ResponseDto<PassengerCardDto> responseDto = new ResponseDto<PassengerCardDto>();

		QPassengerCard passengerCard = QPassengerCard.passengerCard;

//		check passenger card by email
		Optional<PassengerCard> passengerCardEntry = passengerCardRepository
				.findOne(passengerCard.user.id.eq(passengerCardSearchDto.getUserId()));

		if (passengerCardEntry.isPresent()) {

			PassengerCard passengerCardEntity = passengerCardEntry.get();

			responseDto.setObject(mapper.map(passengerCardEntity, PassengerCardDto.class));
			responseDto.setMessage(ResponseMessage.EXIST);

		} else {

			responseDto.setMessage(ResponseMessage.NOT_EXIST);

		}

		return responseDto;

	}

	@Override
	public ResponseDto<PassengerCardDto> rechargePassengerCard(PassengerCardDto passengerCardDto) {

		ResponseDto<PassengerCardDto> responseDto = new ResponseDto<>();

		PassengerCard passengerCard = passengerCardRepository.findById(passengerCardDto.getId()).orElse(null);

		if (passengerCard != null) {

			passengerCard.setPaymentStatus(passengerCardDto.getPaymentStatus());
			passengerCard.setRechargeAmount(passengerCardDto.getRechargeAmount());

//			Recharges amount

			Double totalAmount = passengerCard.getCardAmount() + passengerCardDto.getRechargeAmount();

			passengerCard.setCardAmount(totalAmount);

			// getting current date and time
			Date today = new Date();

			passengerCard.setUpdatedAt(new Timestamp(today.getTime()));
			passengerCard.setUpdatedBy(passengerCardDto.getUpdatedBy());

			passengerCard = passengerCardRepository.save(passengerCard);

			passengerCardDto = mapper.map(passengerCard, PassengerCardDto.class);

			responseDto.setMessage(ResponseMessage.SUCCESS);

		} else {

			responseDto.setMessage(ResponseMessage.UNSUCCESS);

		}

		responseDto.setObject(passengerCardDto);

		return responseDto;

	}

}
