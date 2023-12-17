package com.esad.smartsl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esad.smartsl.domain.dto.TimetableDto;
import com.esad.smartsl.facade.TimetableFacade;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.TimetableSearchDto;

@RestController
@RequestMapping("/smartsl")
public class TimetableController {

	private static final Logger logger = LoggerFactory.getLogger(TimetableController.class);

	@Autowired
	private TimetableFacade timetableFacade;

	@PostMapping("/create-timetable")
	public ResponseEntity<ResponseDto<TimetableDto>> createTimetable(@RequestBody TimetableDto timetableDto) {

		return new ResponseEntity<>(timetableFacade.createTimetable(timetableDto), HttpStatus.OK);

	}

	@PostMapping("/update-timetable")
	public ResponseEntity<ResponseDto<TimetableDto>> updateTimetable(@RequestBody TimetableDto timetableDto) {

		return new ResponseEntity<>(timetableFacade.updateTimetable(timetableDto), HttpStatus.OK);

	}

	@PostMapping("/search-timetable")
	public ResponseEntity<ResponseDto<TimetableDto>> searchTimetable(@RequestBody TimetableSearchDto timetableSearchDto)
			throws Exception {

		return new ResponseEntity<>(timetableFacade.searchTimetable(timetableSearchDto), HttpStatus.OK);

	}

	@PostMapping("/find-timetable-by-id")
	public ResponseEntity<ResponseDto<TimetableDto>> findTimetableById(
			@RequestBody TimetableSearchDto timetableSearchDto) {

		return new ResponseEntity<>(timetableFacade.findTimetableById(timetableSearchDto), HttpStatus.OK);

	}

	@PostMapping("/delete-timetable")
	public ResponseEntity<ResponseDto> deleteTimetable(@RequestBody TimetableDto timetableDto) {

		return new ResponseEntity<>(timetableFacade.deleteTimetable(timetableDto), HttpStatus.OK);

	}

}
