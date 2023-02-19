package com.springboot.graphql.repository;

import com.springboot.graphql.entity.AdditionalItem;
import com.springboot.graphql.entity.PaymentMethod;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AdditionalItemRepository extends JpaRepository<AdditionalItem, Long> {

    Optional<AdditionalItem> findById(Long id);

    @Query(value = "SELECT * FROM public.additional_item ORDER BY created_at OFFSET ?1*?2 LIMIT ?2", nativeQuery = true)
    List<AdditionalItem> get(Integer skip, Integer take);
    
    @Query(value = "SELECT * FROM public.additional_item where payment_method_id ?1 ORDER BY created_at OFFSET ?2*?3 LIMIT ?3", nativeQuery = true)
	List<AdditionalItem> findByPaymentMethod(String name, Integer skip, Integer take);
    
    Optional<AdditionalItem> findByKey(String key);
}
