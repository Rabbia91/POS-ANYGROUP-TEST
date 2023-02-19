package com.springboot.graphql.service.transactionadditionalitem;

import com.springboot.graphql.dto.TransactionAdditionalItemInput;
import com.springboot.graphql.dto.TransactionInput;
import com.springboot.graphql.entity.Transaction;
import com.springboot.graphql.entity.TransactionAdditionalItem;
import com.springboot.graphql.helper.map.MapTransaction;
import com.springboot.graphql.helper.map.MapTransactionAdditionalItem;
import com.springboot.graphql.repository.TransactionAdditionalItemRepository;
import com.springboot.graphql.repository.TransactionRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionAdditionalItemServiceImpl implements TransactionAdditionalItemService {

    private final TransactionAdditionalItemRepository transactionAdditionalItemRepository;

    private final MapTransactionAdditionalItem mapTransactionAdditionalItem;

    private static final Integer DEFAULT_SKIP = 0;

    private static final Integer DEFAULT_LIMIT = 4;

    @Override
    public TransactionAdditionalItem add(TransactionAdditionalItemInput transactionAdditionalItemInput) {
    	TransactionAdditionalItem transaction = mapTransactionAdditionalItem.mapInputToTransactionAdditionalItem(transactionAdditionalItemInput);
        return transactionAdditionalItemRepository.save(transaction);
    }

    @Override
    public TransactionAdditionalItem getById(Long id) {
        return transactionAdditionalItemRepository.findById(id).get();
    }

    @Override
    public List<TransactionAdditionalItem> get(Integer skip, Integer limit) {
        return transactionAdditionalItemRepository.get(skip == null ? DEFAULT_SKIP : skip, limit == null ? DEFAULT_LIMIT : limit);
    }
}
