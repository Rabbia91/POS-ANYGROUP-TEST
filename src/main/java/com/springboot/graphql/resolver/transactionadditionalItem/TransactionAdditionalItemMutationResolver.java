package com.springboot.graphql.resolver.transactionadditionalItem;

import com.springboot.graphql.dto.TransactionAdditionalItemInput;
import com.springboot.graphql.dto.TransactionInput;
import com.springboot.graphql.entity.Transaction;
import com.springboot.graphql.entity.TransactionAdditionalItem;
import com.springboot.graphql.service.transaction.TransactionService;
import com.springboot.graphql.service.transactionadditionalitem.TransactionAdditionalItemService;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionAdditionalItemMutationResolver implements GraphQLMutationResolver {

    private final TransactionAdditionalItemService transactionAdditionalItemService;

    public TransactionAdditionalItem addTransactionAdditionalItem(TransactionAdditionalItemInput transactionAdditionalItemInput) {
        return transactionAdditionalItemService.add(transactionAdditionalItemInput);
    }
}
