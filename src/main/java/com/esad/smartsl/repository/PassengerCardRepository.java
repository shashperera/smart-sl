package com.esad.smartsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esad.smartsl.domain.entity.PassengerCard;

@Repository
public interface PassengerCardRepository
		extends JpaRepository<PassengerCard, Integer>, QuerydslPredicateExecutor<PassengerCard> {

	@Modifying
	@Query("update PassengerCard pc set pc.isDeleted = true where pc.id = :id")
	void deletePassengerCard(@Param("id") Integer id);

	@Query("select pc from PassengerCard pc where pc.isDeleted = false and pc.reference = :reference")
	PassengerCard searchPassengerCardByPhoneNo(@Param("reference") String reference);

	@Modifying
	@Query("update PassengerCard pc set pc.status = 1 where pc.id = :id")
	void activatePassengerCard(@Param("id") Integer id);

}
