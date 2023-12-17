package com.esad.smartsl.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esad.smartsl.domain.dto.UserDto;
import com.esad.smartsl.facade.UserFacade;
import com.esad.smartsl.service.UserService;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.UserSearchDto;

@Service
public class UserFacadeImpl implements UserFacade {

	@Autowired
	private UserService userService;

	@Override
	public ResponseDto<UserDto> createUser(UserDto userDto) {
		ResponseDto<UserDto> responseDto = new ResponseDto<UserDto>();

		responseDto = userService.createUser(userDto);

		return responseDto;
	}

	@Override
	public ResponseDto<UserDto> updateUser(UserDto userDto) {
		ResponseDto<UserDto> responseDto = new ResponseDto<UserDto>();

		responseDto = userService.updateUser(userDto);

		return responseDto;
	}

	@Override
	public ResponseDto<UserDto> searchUser(UserSearchDto userSearchDto) throws Exception {
		ResponseDto<UserDto> responseDto = new ResponseDto<UserDto>();

		responseDto = userService.searchUser(userSearchDto);

		return responseDto;
	}

	@Override
	public ResponseDto<UserDto> findUserById(UserSearchDto userSearchDto) {
		ResponseDto<UserDto> responseDto = new ResponseDto<UserDto>();

		responseDto = userService.findUserById(userSearchDto);

		return responseDto;
	}

	@Override
	public ResponseDto<UserDto> deleteUser(UserDto userDto) {
		ResponseDto<UserDto> responseDto = new ResponseDto<UserDto>();

		responseDto = userService.deleteUser(userDto);

		return responseDto;
	}

}
