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

import com.esad.smartsl.domain.dto.CardPackageDto;
import com.esad.smartsl.facade.CardPackageFacade;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.CardPackageSearchDto;

@RestController
@RequestMapping("/smartsl")
public class CardPackageController {

	private static final Logger logger = LoggerFactory.getLogger(CardPackageController.class);

	@Autowired
	private CardPackageFacade cardPackageFacade;

	@PostMapping("/create-card-package")
	public ResponseEntity<ResponseDto<CardPackageDto>> createCardPackage(@RequestBody CardPackageDto cardPackageDto) {

		return new ResponseEntity<>(cardPackageFacade.createCardPackage(cardPackageDto), HttpStatus.OK);

	}

	@PostMapping("/update-card-package")
	public ResponseEntity<ResponseDto<CardPackageDto>> updateCardPackage(@RequestBody CardPackageDto cardPackageDto) {

		return new ResponseEntity<>(cardPackageFacade.updateCardPackage(cardPackageDto), HttpStatus.OK);

	}

	@PostMapping("/search-card-package")
	public ResponseEntity<ResponseDto<CardPackageDto>> searchCardPackage(
			@RequestBody CardPackageSearchDto cardPackageSearchDto) throws Exception {

		return new ResponseEntity<>(cardPackageFacade.searchCardPackage(cardPackageSearchDto), HttpStatus.OK);

	}

	@PostMapping("/find-card-package-by-id")
	public ResponseEntity<ResponseDto<CardPackageDto>> findCardPackageById(
			@RequestBody CardPackageSearchDto cardPackageSearchDto) {

		return new ResponseEntity<>(cardPackageFacade.findCardPackageById(cardPackageSearchDto), HttpStatus.OK);

	}

	@PostMapping("/delete-card-package")
	public ResponseEntity<ResponseDto<CardPackageDto>> deleteCardPackage(@RequestBody CardPackageDto cardPackageDto) {

		return new ResponseEntity<>(cardPackageFacade.deleteCardPackage(cardPackageDto), HttpStatus.OK);

	}

}
