package com.esad.smartsl.repository;

import com.esad.smartsl.domain.entity.CardPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CardPackageRepository extends JpaRepository<CardPackage, Integer>, QuerydslPredicateExecutor<CardPackage> {

    @Modifying
    @Query("update CardPackage cp set cp.isDeleted = true where cp.id = :id")
    void deleteCardPackage(@Param("id") Integer id);

}
