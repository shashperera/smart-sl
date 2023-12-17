package com.esad.smartsl.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.esad.smartsl.domain.dto.UserDto;
import com.esad.smartsl.domain.entity.QUser;
import com.esad.smartsl.domain.entity.User;
import com.esad.smartsl.repository.UserRepository;
import com.esad.smartsl.service.UserService;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.UserSearchDto;
import com.esad.smartsl.enums.OrderDirection;
import com.google.common.collect.Lists;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ResponseDto<UserDto> createUser(UserDto userDto) {

		// get the current date and time
		Date today = new Date();

		userDto.setCreatedAt(new Timestamp(today.getTime()));

		User user = mapper.map(userDto, User.class);

		user = userRepository.save(user);

		ResponseDto<UserDto> responseDto = new ResponseDto<>();
		responseDto.setObject(mapper.map(user, UserDto.class));

		return responseDto;
	}

	@Override
	public ResponseDto<UserDto> updateUser(UserDto userDto) {
		User user = userRepository.findById(userDto.getId()).orElse(null);

		if (user != null) {
			user.setAddress(userDto.getAddress());
			user.setFirstName(userDto.getFirstName());
			user.setLastName(userDto.getLastName());
			user.setMobileNo(userDto.getMobileNo());
			user.setIsForeigner(userDto.getIsForeigner());
			user.setPassportNumber(userDto.getPassportNumber());
			user.setCity(userDto.getCity());
			user.setStatus(userDto.getStatus());

			// getting current date and time
			Date today = new Date();

			user.setUpdatedAt(new Timestamp(today.getTime()));
			user.setUpdatedBy(userDto.getUpdatedBy());
//            user.setPassword(userRepository.getUserPassword(user.getId()));

			user = userRepository.save(user);

			userDto = mapper.map(user, UserDto.class);

		}

		ResponseDto<UserDto> responseDto = new ResponseDto<>();
		responseDto.setObject(userDto);

		return responseDto;

	}

	@Override
	public ResponseDto<UserDto> searchUser(UserSearchDto userSearchDto) throws Exception {

//        Page<User> userEntries = userRepository.searchUser(userSearchDto.getUsername(),
//                userSearchDto.getEmail(), paging);

		QUser user = QUser.user;

		// setting pagination
		Pageable paging = PageRequest.of(userSearchDto.getCurrentPage(), userSearchDto.getPageSize(),
				userSearchDto.getOrderDirection() == OrderDirection.ASC ? Sort.by(userSearchDto.getSortBy()).ascending()
						: Sort.by(userSearchDto.getSortBy()).descending());

		Iterable<User> userEntries = userRepository.findAll(
				user.username.containsIgnoreCase(userSearchDto.getUsername().toLowerCase()).and(user.email
						.containsIgnoreCase(userSearchDto.getEmail().toLowerCase()).and(user.isDeleted.isFalse())),
				paging);

		long totalItems = userRepository
				.count(user.username.containsIgnoreCase(userSearchDto.getUsername().toLowerCase()).and(user.email
						.containsIgnoreCase(userSearchDto.getEmail().toLowerCase()).and(user.isDeleted.isFalse())));

		ArrayList<User> users = Lists.newArrayList(userEntries);

		ArrayList<UserDto> userDtos = (ArrayList<UserDto>) users.stream()
				.map(entity -> mapper.map(entity, UserDto.class)).collect(Collectors.toList());

		ResponseDto<UserDto> responseDto = new ResponseDto<>();

		responseDto.setLists(userDtos);
		responseDto.setCurrentPage(userSearchDto.getCurrentPage());
		responseDto.setTotalItems((int) totalItems);
		responseDto.setTotalPages((int) Math.ceil((float) totalItems / userSearchDto.getPageSize()));

		return responseDto;

	}

	@Override
	public ResponseDto<UserDto> findUserById(UserSearchDto userSearchDto) {

		User user = userRepository.findById(userSearchDto.getId()).orElse(null);

		ResponseDto<UserDto> responseDto = new ResponseDto<>();
		responseDto.setObject(mapper.map(user, UserDto.class));

		return responseDto;
	}

	@Override
	public ResponseDto<UserDto> findUserByEmail(UserSearchDto userSearchDto) {

		ResponseDto<UserDto> responseDto = new ResponseDto<UserDto>();

		User user = userRepository.findByEmail(userSearchDto.getEmail());

		responseDto.setObject(mapper.map(user, UserDto.class));

		return responseDto;

	}

	@Override
	public ResponseDto<UserDto> deleteUser(UserDto userDto) {

		userRepository.deleteUser(userDto.getId());

		return new ResponseDto<>();

	}

}
