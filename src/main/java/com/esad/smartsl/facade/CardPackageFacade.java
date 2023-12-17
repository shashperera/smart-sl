package com.esad.smartsl.facade;

import javax.transaction.Transactional;

import com.esad.smartsl.domain.dto.CardPackageDto;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.CardPackageSearchDto;

@Transactional
public interface CardPackageFacade {

	ResponseDto<CardPackageDto> createCardPackage(CardPackageDto cardPackageDto);

	ResponseDto<CardPackageDto> updateCardPackage(CardPackageDto cardPackageDto);

	ResponseDto<CardPackageDto> searchCardPackage(CardPackageSearchDto cardPackageSearchDto) throws Exception;

	ResponseDto<CardPackageDto> findCardPackageById(CardPackageSearchDto cardPackageSearchDto);

	ResponseDto<CardPackageDto> deleteCardPackage(CardPackageDto cardPackageDto);

}
