package com.esad.smartsl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.esad.smartsl.domain.dto.UserRoleDto;
import com.esad.smartsl.service.UserRoleService;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.enums.UserRoleName;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRoleTest {

	@Autowired
	private UserRoleService userRoleService;

	@Test
	public void createUserRole() {

		UserRoleDto userRoleDto = new UserRoleDto();

		userRoleDto.setName(UserRoleName.ADMIN);
		userRoleDto.setCode("HR_001");

		ResponseDto<UserRoleDto> responseDto = userRoleService.createUserRole(userRoleDto);

		assertEquals("HR_001", responseDto.getObject().getCode());

		assertNotNull(responseDto.getObject());

	}

	@Test
	void findAll() {

		ResponseDto<UserRoleDto> responseDto = userRoleService.findAll();

		assertNotNull(responseDto.getLists());

	}

	@Test
	void deleteUserRole() {

		UserRoleDto userRoleDto = new UserRoleDto();

		userRoleDto.setId(2);

		ResponseDto<UserRoleDto> responseDto = userRoleService.deleteUserRole(userRoleDto);
		assertNotNull(responseDto);

	}

	@Test
	void updateUserRole() {

		UserRoleDto userRoleDto = new UserRoleDto();

		userRoleDto.setId(1);
		userRoleDto.setName(UserRoleName.ADMIN);
		userRoleDto.setCode("ADMIN_002");
		userRoleDto.setStatus(1);

		ResponseDto<UserRoleDto> responseDto = userRoleService.updateUserRole(userRoleDto);

		assertNotNull(responseDto.getObject());

	}
}
