package com.esad.smartsl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SmartslApplication {

	private static final Logger logger = LoggerFactory.getLogger(SmartslApplication.class);

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

	public static void main(String[] args) {

		SpringApplication.run(SmartslApplication.class, args);
		logger.info("SmartSlApplication Started........");
	}

}
