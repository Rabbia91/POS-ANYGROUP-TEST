package com.springboot.graphql.dto;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionAdditionalItemInput {

    private BigInteger transactionId;
    private String additionalItem;
    private String value;
}
