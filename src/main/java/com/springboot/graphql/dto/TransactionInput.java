package com.springboot.graphql.dto;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionInput {

    private String customerId;
    private Float price;
    private String paymentMethod;
    
    private Date datetime;
    
    private Float priceModifier;
    private Set<TransactionAdditionalItemInput> additionalItem;
}
