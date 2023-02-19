package com.springboot.graphql.dto;

import com.springboot.graphql.entity.enums.Currency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Setter
@Getter
public class AdditionalItemInput {

    private String key;

    private String regex;

    private PaymentMethodInput paymentMethodInput;
}
