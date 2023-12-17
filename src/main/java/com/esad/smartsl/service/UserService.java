package com.esad.smartsl.service;

import org.springframework.transaction.annotation.Transactional;

import com.esad.smartsl.domain.dto.UserDto;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.UserSearchDto;

@Transactional
public interface UserService {

	ResponseDto<UserDto> createUser(UserDto userDto);

	ResponseDto<UserDto> updateUser(UserDto userDto);

	ResponseDto<UserDto> searchUser(UserSearchDto userSearchDto) throws Exception;

	ResponseDto<UserDto> findUserById(UserSearchDto userSearchDto);

	ResponseDto<UserDto> findUserByEmail(UserSearchDto userSearchDto);

	ResponseDto<UserDto> deleteUser(UserDto userDto);

}
