package com.springboot.graphql.resolver.transaction;

import com.springboot.graphql.entity.Transaction;
import com.springboot.graphql.service.transaction.TransactionService;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Component
@AllArgsConstructor
public class TransactionQueryResolver implements GraphQLQueryResolver {

    private final TransactionService transactionService;

    public Transaction getTransactionById(Long id) {
        return transactionService.getById(id);
    }

    public List<Transaction> getTransactions(Integer skip, Integer limit) {
        return transactionService.get(skip, limit);
    }
    
    public List<Transaction> transactionsBetween(Date start, Date end) {
        return transactionService.transactionsBetween(start, end);
      }
    
}