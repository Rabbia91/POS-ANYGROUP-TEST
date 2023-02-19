package com.springboot.graphql.repository;

import com.springboot.graphql.entity.Transaction;
import com.springboot.graphql.entity.TransactionAdditionalItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TransactionAdditionalItemRepository extends JpaRepository<TransactionAdditionalItem, Long> {

    Optional<TransactionAdditionalItem> findById(Long id);

    @Query(value = "SELECT * FROM public.trade_type ORDER BY created_at OFFSET ?1*?2 LIMIT ?2", nativeQuery = true)
    List<TransactionAdditionalItem> get(Integer skip, Integer take);
}
