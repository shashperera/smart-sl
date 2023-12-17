package com.esad.smartsl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esad.smartsl.domain.dto.UserRoleDto;
import com.esad.smartsl.facade.UserRoleFacade;
import com.esad.smartsl.dto.responseDto.ResponseDto;

@RestController
@CrossOrigin
@RequestMapping("/smartsl")
public class UserRoleController {

	private static final Logger logger = LoggerFactory.getLogger(UserRoleController.class);

	@Autowired
	private UserRoleFacade userRoleFacade;

	@PostMapping("/create-user-role")
	public ResponseEntity<ResponseDto<UserRoleDto>> createUserRole(@RequestBody UserRoleDto userRoleDto) {

		logger.info("Inside create User in UserRoleController........");

		return new ResponseEntity<>(userRoleFacade.createUserRole(userRoleDto), HttpStatus.OK);

	}

	@GetMapping("/find-all")
	public ResponseEntity<ResponseDto<UserRoleDto>> findAll() {

		return new ResponseEntity<>(userRoleFacade.findAll(), HttpStatus.OK);

	}

	@PostMapping("/delete-user-role")
	public ResponseEntity<ResponseDto<UserRoleDto>> deleteUserRole(@RequestBody UserRoleDto userRoleDto) {

		return new ResponseEntity<>(userRoleFacade.deleteUserRole(userRoleDto), HttpStatus.OK);

	}

	@PostMapping("/update-user-role")
	public ResponseEntity<ResponseDto<UserRoleDto>> updateUserRole(@RequestBody UserRoleDto userRoleDto) {

		return new ResponseEntity<>(userRoleFacade.updateUserRole(userRoleDto), HttpStatus.OK);

	}

}
