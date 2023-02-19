package com.springboot.graphql.helper.map;

import com.springboot.graphql.dto.AdditionalItemInput;
import com.springboot.graphql.entity.AdditionalItem;
import com.springboot.graphql.entity.PaymentMethod;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MapAdditionalItem {

    public AdditionalItem mapInputToAdditionalItem(AdditionalItemInput additionalItemInput, PaymentMethod paymentMethod) {
        AdditionalItem additionalItem = new AdditionalItem();

        additionalItem.setKey(additionalItemInput.getKey());
        additionalItem.setRegex(additionalItemInput.getRegex());
        additionalItem.setPaymentMethod(paymentMethod);

        return additionalItem;
    }
}
