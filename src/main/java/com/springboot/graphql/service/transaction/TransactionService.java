package com.springboot.graphql.service.transaction;

import com.springboot.graphql.dto.TransactionInput;
import com.springboot.graphql.entity.Transaction;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface TransactionService {

    Transaction add(TransactionInput transactionInput);

    Transaction getById(Long id);

    List<Transaction> get(Integer skip, Integer limit);

	List<Transaction> transactionsBetween(Date start, Date end);
}
