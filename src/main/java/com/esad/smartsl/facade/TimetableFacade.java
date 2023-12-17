package com.esad.smartsl.facade;

import javax.transaction.Transactional;

import com.esad.smartsl.domain.dto.TimetableDto;
import com.esad.smartsl.dto.responseDto.ResponseDto;
import com.esad.smartsl.dto.searchDto.TimetableSearchDto;

@Transactional
public interface TimetableFacade {

	ResponseDto<TimetableDto> createTimetable(TimetableDto timetableDto);

	ResponseDto<TimetableDto> updateTimetable(TimetableDto timetableDto);

	ResponseDto<TimetableDto> searchTimetable(TimetableSearchDto timetableSearchDto) throws Exception;

	ResponseDto<TimetableDto> findTimetableById(TimetableSearchDto timetableSearchDto);

	ResponseDto<TimetableDto> deleteTimetable(TimetableDto timetableDto);

}
