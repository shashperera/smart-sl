package com.esad.smartsl.repository;

import com.esad.smartsl.domain.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>, QuerydslPredicateExecutor<Vehicle> {

}
