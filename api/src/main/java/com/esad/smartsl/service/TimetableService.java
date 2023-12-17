package com.esad.smartsl.service;

import com.esad.smartsl.domain.dto.TimetableDto;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.TimetableSearchDto;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TimetableService {

	ResponseDto<TimetableDto> createTimetable(TimetableDto timetableDto);

	ResponseDto<TimetableDto> updateTimetable(TimetableDto timetableDto);

	ResponseDto<TimetableDto> searchTimetable(TimetableSearchDto timetableSearchDto) throws Exception;

	ResponseDto<TimetableDto> findTimetableById(TimetableSearchDto timetableSearchDto);

	ResponseDto<TimetableDto> deleteTimetable(TimetableDto timetableDto);

}
