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

import com.esad.smartsl.domain.dto.UserDto;
import com.esad.smartsl.facade.UserFacade;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.UserSearchDto;

@RestController
@RequestMapping("/smartsl")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserFacade userFacade;

	@PostMapping("/create-user")
	public ResponseEntity<ResponseDto<UserDto>> createUser(@RequestBody UserDto userDto) {

		return new ResponseEntity<>(userFacade.createUser(userDto), HttpStatus.OK);

	}

	@PostMapping("/update-user")
	public ResponseEntity<ResponseDto<UserDto>> updateUser(@RequestBody UserDto userDto) {

		return new ResponseEntity<>(userFacade.updateUser(userDto), HttpStatus.OK);

	}

	@PostMapping("/search-user")
	public ResponseEntity<ResponseDto<UserDto>> searchUser(@RequestBody UserSearchDto userSearchDto) throws Exception {

		return new ResponseEntity<>(userFacade.searchUser(userSearchDto), HttpStatus.OK);

	}

	@PostMapping("/find-user-by-id")
	public ResponseEntity<ResponseDto<UserDto>> findUserById(@RequestBody UserSearchDto userSearchDto) {

		return new ResponseEntity<>(userFacade.findUserById(userSearchDto), HttpStatus.OK);

	}

	@PostMapping("/delete-user")
	public ResponseEntity<ResponseDto<UserDto>> deleteUser(@RequestBody UserDto userDto) {

		return new ResponseEntity<>(userFacade.deleteUser(userDto), HttpStatus.OK);

	}

}
