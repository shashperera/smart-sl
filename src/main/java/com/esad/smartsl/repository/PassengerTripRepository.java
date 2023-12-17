package com.esad.smartsl.repository;

import com.esad.smartsl.domain.entity.PassengerTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerTripRepository extends JpaRepository<PassengerTrip, Integer>, QuerydslPredicateExecutor<PassengerTrip> {

    @Modifying
    @Query("update PassengerTrip pt set pt.isDeleted = true where pt.id = :id")
    void deletePassengerTrip(@Param("id") Integer id);

}
