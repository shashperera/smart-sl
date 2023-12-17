package com.esad.smartsl.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esad.smartsl.domain.dto.CardPackageDto;
import com.esad.smartsl.facade.CardPackageFacade;
import com.esad.smartsl.service.CardPackageService;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.CardPackageSearchDto;

@Service
public class CardPackageFacadeImpl implements CardPackageFacade {

	@Autowired
	private CardPackageService cardPackageService;

	@Override
	public ResponseDto<CardPackageDto> createCardPackage(CardPackageDto cardPackageDto) {
		ResponseDto<CardPackageDto> responseDto = new ResponseDto<CardPackageDto>();

		responseDto = cardPackageService.createCardPackage(cardPackageDto);

		return responseDto;
	}

	@Override
	public ResponseDto<CardPackageDto> updateCardPackage(CardPackageDto cardPackageDto) {
		ResponseDto<CardPackageDto> responseDto = new ResponseDto<CardPackageDto>();

		responseDto = cardPackageService.updateCardPackage(cardPackageDto);

		return responseDto;
	}

	@Override
	public ResponseDto<CardPackageDto> searchCardPackage(CardPackageSearchDto cardPackageSearchDto) throws Exception {
		ResponseDto<CardPackageDto> responseDto = new ResponseDto<CardPackageDto>();

		responseDto = cardPackageService.searchCardPackage(cardPackageSearchDto);

		return responseDto;
	}

	@Override
	public ResponseDto<CardPackageDto> findCardPackageById(CardPackageSearchDto cardPackageSearchDto) {
		ResponseDto<CardPackageDto> responseDto = new ResponseDto<CardPackageDto>();

		responseDto = cardPackageService.findCardPackageById(cardPackageSearchDto);

		return responseDto;
	}

	@Override
	public ResponseDto<CardPackageDto> deleteCardPackage(CardPackageDto cardPackageDto) {
		ResponseDto<CardPackageDto> responseDto = new ResponseDto<CardPackageDto>();

		responseDto = cardPackageService.deleteCardPackage(cardPackageDto);

		return responseDto;
	}

}
