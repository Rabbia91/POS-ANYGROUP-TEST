package com.springboot.graphql.resolver.additionalitem;

import com.springboot.graphql.dto.PaymentMethodInput;
import com.springboot.graphql.entity.AdditionalItem;
import com.springboot.graphql.service.additionalmethod.AdditionalItemService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AdditionalItemQueryResolver implements GraphQLQueryResolver {

    private final AdditionalItemService additionalItemService;

    public AdditionalItem getAdditionalItemById(Long id) {
        return additionalItemService.getById(id);
    }

    public List<AdditionalItem> getAdditionalItems(Integer skip, Integer limit) {
        return additionalItemService.get(skip, limit);
    }
    
    public List<AdditionalItem> getAdditionalItemsByPaymentMethod(PaymentMethodInput paymentMethodInput, Integer skip, Integer limit) {
        return additionalItemService.get(paymentMethodInput, skip, limit);
    }
    
}
