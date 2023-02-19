package com.springboot.graphql.resolver.paymentmethod;

import com.springboot.graphql.dto.PaymentMethodInput;
import com.springboot.graphql.entity.PaymentMethod;
import com.springboot.graphql.service.paymentmethod.PaymentMethodService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PaymentMethodMutationResolver implements GraphQLMutationResolver {

    private final PaymentMethodService paymentMethodService;

    public PaymentMethod addPaymentMethod(PaymentMethodInput paymentMethodInput) {
        return paymentMethodService.add(paymentMethodInput);
    }
}
