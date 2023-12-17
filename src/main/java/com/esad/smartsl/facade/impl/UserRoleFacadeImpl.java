package com.esad.smartsl.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esad.smartsl.domain.dto.UserRoleDto;
import com.esad.smartsl.facade.UserRoleFacade;
import com.esad.smartsl.service.UserRoleService;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.enums.ResponseMessage;

@Service
public class UserRoleFacadeImpl implements UserRoleFacade {

	@Autowired
	private UserRoleService userRoleService;

	@Override
	public ResponseDto<UserRoleDto> createUserRole(UserRoleDto userRoleDto) {

		ResponseDto<UserRoleDto> responseDto = new ResponseDto<UserRoleDto>();

//		check if user role already exist
		responseDto = userRoleService.checkUserRoleExistByName(userRoleDto);

//		if not exist create new record
		if (responseDto.getMessage().equals(ResponseMessage.NOT_EXIST)) {

			responseDto = userRoleService.createUserRole(userRoleDto);

		}

		return responseDto;
	}

	@Override
	public ResponseDto<UserRoleDto> checkUserRoleExistByName(UserRoleDto userRoleDto) {

		ResponseDto<UserRoleDto> responseDto = new ResponseDto<UserRoleDto>();

		responseDto = userRoleService.checkUserRoleExistByName(userRoleDto);

		return responseDto;

	}

	@Override
	public ResponseDto<UserRoleDto> findAll() {

		ResponseDto<UserRoleDto> responseDto = new ResponseDto<UserRoleDto>();

		responseDto = userRoleService.findAll();

		return responseDto;

	}

	@Override
	public ResponseDto<UserRoleDto> deleteUserRole(UserRoleDto userRoleDto) {

		ResponseDto<UserRoleDto> responseDto = new ResponseDto<UserRoleDto>();

		responseDto = userRoleService.deleteUserRole(userRoleDto);

		return responseDto;

	}

	@Override
	public ResponseDto<UserRoleDto> updateUserRole(UserRoleDto userRoleDto) {

		ResponseDto<UserRoleDto> responseDto = new ResponseDto<UserRoleDto>();

		responseDto = userRoleService.updateUserRole(userRoleDto);

		return responseDto;

	}

}
