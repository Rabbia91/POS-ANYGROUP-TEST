package com.springboot.graphql.resolver.transactionadditionalItem;

import com.springboot.graphql.entity.Transaction;
import com.springboot.graphql.entity.TransactionAdditionalItem;
import com.springboot.graphql.service.transaction.TransactionService;
import com.springboot.graphql.service.transactionadditionalitem.TransactionAdditionalItemService;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@AllArgsConstructor
public class TransactionAdditionalItemQueryResolver implements GraphQLQueryResolver {

    private final TransactionAdditionalItemService transactionAdditionalItemService;

    public TransactionAdditionalItem getTransactionAdditionalItemById(Long id) {
        return transactionAdditionalItemService.getById(id);
    }

    public List<TransactionAdditionalItem> getTransactionAdditionalItems(Integer skip, Integer limit) {
        return transactionAdditionalItemService.get(skip, limit);
    }
    
}