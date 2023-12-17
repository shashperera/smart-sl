package com.esad.smartsl.service;

import com.esad.smartsl.domain.dto.CardPackageDto;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.CardPackageSearchDto;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CardPackageService {

	ResponseDto<CardPackageDto> createCardPackage(CardPackageDto cardPackageDto);

	ResponseDto<CardPackageDto> updateCardPackage(CardPackageDto cardPackageDto);

	ResponseDto<CardPackageDto> searchCardPackage(CardPackageSearchDto cardPackageSearchDto) throws Exception;

	ResponseDto<CardPackageDto> findCardPackageById(CardPackageSearchDto cardPackageSearchDto);

	ResponseDto<CardPackageDto> deleteCardPackage(CardPackageDto cardPackageDto);

}
