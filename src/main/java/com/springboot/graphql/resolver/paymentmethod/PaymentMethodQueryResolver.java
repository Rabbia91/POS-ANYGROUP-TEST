package com.springboot.graphql.resolver.paymentmethod;

import com.springboot.graphql.entity.PaymentMethod;
import com.springboot.graphql.service.paymentmethod.PaymentMethodService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PaymentMethodQueryResolver implements GraphQLQueryResolver {

    private final PaymentMethodService paymentMethodService;

    public PaymentMethod getPaymentMethodById(Long id) {
        return paymentMethodService.getById(id);
    }

    public List<PaymentMethod> getPaymentMethods(Integer skip, Integer limit) {
        return paymentMethodService.get(skip, limit);
    }
}