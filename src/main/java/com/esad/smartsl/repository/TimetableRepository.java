package com.esad.smartsl.repository;

import com.esad.smartsl.domain.entity.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

public interface TimetableRepository extends JpaRepository<Timetable, Integer>, QuerydslPredicateExecutor<Timetable> {

    @Modifying
    @Query("update Timetable t set t.isDeleted = true where t.id = :id")
    void deleteTimetable(@Param("id") Integer id);

}
