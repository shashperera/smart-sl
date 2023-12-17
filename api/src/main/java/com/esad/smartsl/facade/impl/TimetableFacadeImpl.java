package com.esad.smartsl.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esad.smartsl.domain.dto.TimetableDto;
import com.esad.smartsl.facade.TimetableFacade;
import com.esad.smartsl.service.TimetableService;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.TimetableSearchDto;

@Service
public class TimetableFacadeImpl implements TimetableFacade {

	@Autowired
	private TimetableService timetableService;

	@Override
	public ResponseDto<TimetableDto> createTimetable(TimetableDto timetableDto) {
		ResponseDto<TimetableDto> responseDto = new ResponseDto<TimetableDto>();

		responseDto = timetableService.createTimetable(timetableDto);

		return responseDto;
	}

	@Override
	public ResponseDto<TimetableDto> updateTimetable(TimetableDto timetableDto) {
		ResponseDto<TimetableDto> responseDto = new ResponseDto<TimetableDto>();

		responseDto = timetableService.updateTimetable(timetableDto);

		return responseDto;
	}

	@Override
	public ResponseDto<TimetableDto> searchTimetable(TimetableSearchDto timetableSearchDto) throws Exception {
		ResponseDto<TimetableDto> responseDto = new ResponseDto<TimetableDto>();

		responseDto = timetableService.searchTimetable(timetableSearchDto);

		return responseDto;
	}

	@Override
	public ResponseDto<TimetableDto> findTimetableById(TimetableSearchDto timetableSearchDto) {
		ResponseDto<TimetableDto> responseDto = new ResponseDto<TimetableDto>();

		responseDto = timetableService.findTimetableById(timetableSearchDto);

		return responseDto;
	}

	@Override
	public ResponseDto<TimetableDto> deleteTimetable(TimetableDto timetableDto) {
		ResponseDto<TimetableDto> responseDto = new ResponseDto<TimetableDto>();

		responseDto = timetableService.deleteTimetable(timetableDto);

		return responseDto;
	}

}
