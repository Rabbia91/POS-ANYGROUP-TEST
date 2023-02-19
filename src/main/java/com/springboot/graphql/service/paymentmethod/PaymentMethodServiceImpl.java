package com.springboot.graphql.service.paymentmethod;

import com.springboot.graphql.dto.PaymentMethodInput;
import com.springboot.graphql.entity.PaymentMethod;
import com.springboot.graphql.helper.map.MapPaymentMethod;
import com.springboot.graphql.repository.PaymentMethodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;
    
    private final MapPaymentMethod mapPaymentMethod;

    private static final Integer DEFAULT_SKIP = 0;

    private static final Integer DEFAULT_LIMIT = 4;

    @Override
    public PaymentMethod add(PaymentMethodInput paymentMethodInput) {
        PaymentMethod paymentMethod = mapPaymentMethod.mapInputToPaymentMethod(paymentMethodInput);
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public PaymentMethod getById(Long id) {
        return paymentMethodRepository.findById(id).get();
    }
    
    @Override
    public PaymentMethod getByName(String name) {
        return paymentMethodRepository.findByName(name).get();
    }

    @Override
    public List<PaymentMethod> get(Integer skip, Integer limit) {
        return paymentMethodRepository.get(skip == null ? DEFAULT_SKIP : skip, limit == null ? DEFAULT_LIMIT : limit);
    }
}
