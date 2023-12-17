package com.esad.smartsl.facade;

import javax.transaction.Transactional;

import com.esad.smartsl.domain.dto.UserRoleDto;
import com.esad.smartsl.dto.responseDto.ResponseDto;

@Transactional
public interface UserRoleFacade {

	ResponseDto<UserRoleDto> createUserRole(UserRoleDto userRoleDto);

	ResponseDto<UserRoleDto> checkUserRoleExistByName(UserRoleDto userRoleDto);

	ResponseDto<UserRoleDto> findAll();

	ResponseDto<UserRoleDto> deleteUserRole(UserRoleDto userRoleDto);

	ResponseDto<UserRoleDto> updateUserRole(UserRoleDto userRoleDto);

}
