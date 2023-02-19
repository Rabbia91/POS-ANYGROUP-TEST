package com.springboot.graphql.repository;

import com.springboot.graphql.entity.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findById(Long id);

    @Query(value = "SELECT * FROM public.trade_type ORDER BY created_at OFFSET ?1*?2 LIMIT ?2", nativeQuery = true)
    List<Transaction> get(Integer skip, Integer take);
    
    List<Transaction> findByDatetimeBetween(Date startDate, Date endDate);
}
