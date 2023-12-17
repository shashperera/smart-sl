package com.esad.smartsl.service;

import com.esad.smartsl.domain.dto.UserRoleDto;
import com.esad.smartsl.dto.responseDto.ResponseDto;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRoleService {

	ResponseDto<UserRoleDto> createUserRole(UserRoleDto userRoleDto);

	ResponseDto<UserRoleDto> checkUserRoleExistByName(UserRoleDto userRoleDto);

	ResponseDto<UserRoleDto> findAll();

	ResponseDto<UserRoleDto> deleteUserRole(UserRoleDto userRoleDto);

	ResponseDto<UserRoleDto> updateUserRole(UserRoleDto userRoleDto);

}
