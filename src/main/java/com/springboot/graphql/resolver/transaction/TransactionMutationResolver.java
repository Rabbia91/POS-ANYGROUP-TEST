package com.springboot.graphql.resolver.transaction;

import com.springboot.graphql.dto.TransactionInput;
import com.springboot.graphql.entity.Transaction;
import com.springboot.graphql.service.transaction.TransactionService;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionMutationResolver implements GraphQLMutationResolver {

    private final TransactionService transactionService;

    public Transaction addTransaction(TransactionInput transactionInput) {
        return transactionService.add(transactionInput);
    }
}
