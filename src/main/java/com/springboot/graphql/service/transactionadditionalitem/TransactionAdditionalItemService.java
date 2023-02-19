package com.springboot.graphql.service.transactionadditionalitem;

import com.springboot.graphql.dto.TransactionAdditionalItemInput;
import com.springboot.graphql.dto.TransactionInput;
import com.springboot.graphql.entity.Transaction;
import com.springboot.graphql.entity.TransactionAdditionalItem;

import java.util.List;

public interface TransactionAdditionalItemService {

    TransactionAdditionalItem add(TransactionAdditionalItemInput transactionAdditionalItemInput);

    TransactionAdditionalItem getById(Long id);

    List<TransactionAdditionalItem> get(Integer skip, Integer limit);
}
