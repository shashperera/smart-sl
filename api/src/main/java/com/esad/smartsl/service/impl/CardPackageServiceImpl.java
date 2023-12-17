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

import com.esad.smartsl.domain.dto.CardPackageDto;
import com.esad.smartsl.domain.entity.CardPackage;
import com.esad.smartsl.domain.entity.QCardPackage;
import com.esad.smartsl.repository.CardPackageRepository;
import com.esad.smartsl.service.CardPackageService;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.CardPackageSearchDto;
import com.google.common.collect.Lists;

@Service
public class CardPackageServiceImpl implements CardPackageService {

	private static final Logger logger = LoggerFactory.getLogger(CardPackageServiceImpl.class);

	@Autowired
	private CardPackageRepository cardPackageRepository;

	@Autowired
	private ModelMapper mapper;

//    Create card package
	@Override
	public ResponseDto<CardPackageDto> createCardPackage(CardPackageDto cardPackageDto) {

//		get the current date and time
		Date today = new Date();

//		set the server time to createdAt field
		cardPackageDto.setCreatedAt(new Timestamp(today.getTime()));

//		mapped dto object to entity object
		CardPackage cardPackage = mapper.map(cardPackageDto, CardPackage.class);

//		create record in the DB using jpa repository
		cardPackage = cardPackageRepository.save(cardPackage);

		ResponseDto<CardPackageDto> responseDto = new ResponseDto<>();

//		set returned object from db to response dto
		responseDto.setObject(mapper.map(cardPackage, CardPackageDto.class));

		return responseDto;
	}

//	update card package
	@Override
	public ResponseDto<CardPackageDto> updateCardPackage(CardPackageDto cardPackageDto) {

//		find the existing record using id
		CardPackage cardPackage = cardPackageRepository.findById(cardPackageDto.getId()).orElse(null);

//		update only if the record exist
		if (cardPackage != null) {

//			setting the updating values
			cardPackage.setName(cardPackageDto.getName());
			cardPackage.setCode(cardPackageDto.getCode());
			cardPackage.setAmount(cardPackageDto.getAmount());
			cardPackage.setDescription(cardPackageDto.getDescription());
			cardPackage.setStatus(cardPackageDto.getStatus());

			// getting current date and time
			Date today = new Date();

			cardPackage.setUpdatedAt(new Timestamp(today.getTime()));
			cardPackage.setUpdatedBy(cardPackage.getUpdatedBy());

//			update the record
			cardPackage = cardPackageRepository.save(cardPackage);

			cardPackageDto = mapper.map(cardPackage, CardPackageDto.class);

		}

		ResponseDto<CardPackageDto> responseDto = new ResponseDto<>();
		responseDto.setObject(cardPackageDto);

		return responseDto;

	}

//	search card packages
	@Override
	public ResponseDto<CardPackageDto> searchCardPackage(CardPackageSearchDto cardPackageSearchDto) throws Exception {
//
		QCardPackage cardPackage = QCardPackage.cardPackage;

		// setting pagination
		Pageable paging = PageRequest.of(cardPackageSearchDto.getCurrentPage(), cardPackageSearchDto.getPageSize(),
				Sort.by(cardPackageSearchDto.getSortBy()));

//		search cardPackages according to the filters with pagination
		Iterable<CardPackage> cardPackageEntries = cardPackageRepository.findAll(
				cardPackage.name.containsIgnoreCase(cardPackageSearchDto.getName()).and(cardPackage.code
						.containsIgnoreCase(cardPackageSearchDto.getCode()).and(cardPackage.isDeleted.isFalse())),
				paging);

//		get the totalItem count
		long totalItems = cardPackageRepository
				.count(cardPackage.name.containsIgnoreCase(cardPackageSearchDto.getName()).and(cardPackage.code
						.containsIgnoreCase(cardPackageSearchDto.getCode()).and(cardPackage.isDeleted.isFalse())));

		ArrayList<CardPackage> cardPackages = Lists.newArrayList(cardPackageEntries);

		ArrayList<CardPackageDto> cardPackageDtos = (ArrayList<CardPackageDto>) cardPackages.stream()
				.map(entity -> mapper.map(entity, CardPackageDto.class)).collect(Collectors.toList());

		ResponseDto<CardPackageDto> responseDto = new ResponseDto<>();

//		set the values to response dto
		responseDto.setLists(cardPackageDtos);
		responseDto.setCurrentPage(cardPackageSearchDto.getCurrentPage());
		responseDto.setTotalItems((int) totalItems);
		responseDto.setTotalPages((int) Math.ceil((float) totalItems / cardPackageSearchDto.getPageSize()));
//
		return responseDto;

	}

//	find card package using id
	@Override
	public ResponseDto<CardPackageDto> findCardPackageById(CardPackageSearchDto cardPackageSearchDto) {

//		find the record by id
		CardPackage cardPackage = cardPackageRepository.findById(cardPackageSearchDto.getId()).orElse(null);

		ResponseDto<CardPackageDto> responseDto = new ResponseDto<>();
		responseDto.setObject(mapper.map(cardPackage, CardPackageDto.class));

		return responseDto;
	}

//	delete card package record
	@Override
	public ResponseDto<CardPackageDto> deleteCardPackage(CardPackageDto cardPackageDto) {

		cardPackageRepository.deleteCardPackage(cardPackageDto.getId());

		return new ResponseDto<>();

	}

}
