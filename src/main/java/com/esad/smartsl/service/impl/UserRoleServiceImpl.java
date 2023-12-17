package com.esad.smartsl.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esad.smartsl.domain.dto.UserRoleDto;
import com.esad.smartsl.domain.entity.QUserRole;
import com.esad.smartsl.domain.entity.UserRole;
import com.esad.smartsl.repository.UserRoleRepository;
import com.esad.smartsl.service.UserRoleService;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.enums.ResponseMessage;
import com.google.common.collect.Lists;

@Component
public class UserRoleServiceImpl implements UserRoleService {

	private static final Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ResponseDto<UserRoleDto> createUserRole(UserRoleDto userRoleDto) {

		logger.info("Create user in UserRoleService.......");

		// get today date and time
		Date today = new Date();

		userRoleDto.setCreatedAt(new Timestamp(today.getTime()));

		UserRole userRole = mapper.map(userRoleDto, UserRole.class);

		userRole = userRoleRepository.save(userRole);

		ResponseDto<UserRoleDto> responseDto = new ResponseDto<>();

		responseDto.setObject(mapper.map(userRole, UserRoleDto.class));

		return responseDto;
	}

	@Override
	public ResponseDto<UserRoleDto> checkUserRoleExistByName(UserRoleDto userRoleDto) {

		ResponseDto<UserRoleDto> responseDto = new ResponseDto<UserRoleDto>();

		UserRole existUserRole = userRoleRepository.checkUserRoleExistByName(userRoleDto.getName());

		if (existUserRole != null) {

			userRoleDto = mapper.map(existUserRole, UserRoleDto.class);

			responseDto.setMessage(ResponseMessage.EXIST);

		} else {
			responseDto.setMessage(ResponseMessage.NOT_EXIST);
		}

		responseDto.setObject(userRoleDto);

		return responseDto;

	}

	@Override
	public ResponseDto<UserRoleDto> findAll() {

		QUserRole userRole = QUserRole.userRole;

		Iterable<UserRole> userRoleEntities = userRoleRepository.findAll(userRole.isDeleted.isFalse());

		ArrayList<UserRole> userRoles = Lists.newArrayList(userRoleEntities);

		ArrayList<UserRoleDto> userRoleDtos = (ArrayList<UserRoleDto>) userRoles.stream()
				.map(entity -> mapper.map(entity, UserRoleDto.class)).collect(Collectors.toList());

		ResponseDto<UserRoleDto> responseDto = new ResponseDto<>();

		responseDto.setLists(userRoleDtos);

		return responseDto;

	}

	@Override
	public ResponseDto<UserRoleDto> deleteUserRole(UserRoleDto userRoleDto) {

		userRoleRepository.deleteUserRole(userRoleDto.getId());

		return new ResponseDto<>();

	}

	@Override
	public ResponseDto<UserRoleDto> updateUserRole(UserRoleDto userRoleDto) {
		UserRole userRole = userRoleRepository.findById(userRoleDto.getId()).orElse(null);

		if (userRole != null) {
			userRole.setLabel(userRoleDto.getLabel());
			userRole.setName(userRoleDto.getName());
			userRole.setCode(userRoleDto.getCode());

			Date today = new Date();

			userRole.setUpdatedAt(new Timestamp(today.getTime()));
			userRole.setUpdatedBy(userRoleDto.getUpdatedBy());
			userRole.setStatus(userRoleDto.getStatus());
//            user.setPassword(userRepository.getUserPassword(user.getId()));

			userRole = userRoleRepository.save(userRole);

			userRoleDto = mapper.map(userRole, UserRoleDto.class);

		}

		ResponseDto<UserRoleDto> responseDto = new ResponseDto<>();
		responseDto.setObject(userRoleDto);

		return responseDto;

	}

}
