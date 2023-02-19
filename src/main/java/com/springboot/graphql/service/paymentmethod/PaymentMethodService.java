package com.springboot.graphql.service.paymentmethod;

import com.springboot.graphql.dto.PaymentMethodInput;
import com.springboot.graphql.entity.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {

    PaymentMethod add(PaymentMethodInput paymentMethodInput);

    PaymentMethod getById(Long id);

    List<PaymentMethod> get(Integer skip, Integer limit);

	PaymentMethod getByName(String paymentMethod);
}
