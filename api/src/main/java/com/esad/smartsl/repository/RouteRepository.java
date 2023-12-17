package com.esad.smartsl.repository;

import com.esad.smartsl.domain.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer>, QuerydslPredicateExecutor<Route> {

    @Modifying
    @Query("update Route r set r.isDeleted = true where r.id = :id")
    void deleteRoute(@Param("id") Integer id);

}
