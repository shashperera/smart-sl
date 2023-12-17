package com.esad.smartsl.repository;

import com.esad.smartsl.domain.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>, QuerydslPredicateExecutor<Payment> {

    @Modifying
    @Query("update Payment p set p.isDeleted = true where p.id = :id")
    void deletePayment(@Param("id") Integer id);

}
