package com.springboot.graphql.dto;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentMethodInput {

    private String name;
    private Float minPriceModifier;
    private Float maxPriceModifier;
    private Float pointsModifier;
    private Set<AdditionalItemInput> additionalItem;
}
