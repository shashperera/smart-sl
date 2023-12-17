package com.esad.smartsl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.esad.smartsl.domain.dto.PassengerCardDto;
import com.esad.smartsl.service.PassengerCardService;
import com.esad.smartsl.dto.responseDto.ResponseDto;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PassengerCardTest {

	@Autowired
	private PassengerCardService passengerCardService;

	@Test
	public void activatePassengerCardTest() {

		PassengerCardDto passengerCardDto = new PassengerCardDto();
		passengerCardDto.setReference("0711785876");

		ResponseDto<PassengerCardDto> responseDto = passengerCardService.activatePassengerCard(passengerCardDto);

		assertNotNull(responseDto.getObject());

	}
}
