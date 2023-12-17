package com.esad.smartsl.facade;

import javax.transaction.Transactional;

import com.esad.smartsl.domain.dto.UserDto;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.UserSearchDto;

@Transactional
public interface UserFacade {

	ResponseDto<UserDto> createUser(UserDto userDto);

	ResponseDto<UserDto> updateUser(UserDto userDto);

	ResponseDto<UserDto> searchUser(UserSearchDto userSearchDto) throws Exception;

	ResponseDto<UserDto> findUserById(UserSearchDto userSearchDto);

	ResponseDto<UserDto> deleteUser(UserDto userDto);

}
