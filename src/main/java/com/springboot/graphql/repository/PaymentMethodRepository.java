package com.springboot.graphql.repository;

import com.springboot.graphql.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

    Optional<PaymentMethod> findById(Long id);

    @Query(value = "SELECT * FROM public.payment_method ORDER BY created_at OFFSET ?1*?2 LIMIT ?2", nativeQuery = true)
    List<PaymentMethod> get(Integer skip, Integer take);

	Optional<PaymentMethod> findByName(String name);
}
