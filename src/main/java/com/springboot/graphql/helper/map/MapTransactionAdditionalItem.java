package com.springboot.graphql.helper.map;

import com.springboot.graphql.dto.TransactionAdditionalItemInput;
import com.springboot.graphql.dto.TransactionInput;
import com.springboot.graphql.entity.Transaction;
import com.springboot.graphql.entity.TransactionAdditionalItem;
import com.springboot.graphql.repository.AdditionalItemRepository;
import com.springboot.graphql.service.additionalmethod.AdditionalItemService;
import com.springboot.graphql.service.paymentmethod.PaymentMethodService;
import com.springboot.graphql.service.transaction.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MapTransactionAdditionalItem {
	
	@Autowired
    private TransactionService transactionService;
	
	@Autowired
    private AdditionalItemService additionaItemService;

	
    public TransactionAdditionalItem mapInputToTransactionAdditionalItem(TransactionAdditionalItemInput transactionAdditionalItemInput) {
        TransactionAdditionalItem transactionAdditionalItem = new TransactionAdditionalItem();
        
        transactionAdditionalItem.setTransaction(transactionService.getById(Long.parseLong(String.valueOf(transactionAdditionalItemInput.getTransactionId()))));
        transactionAdditionalItem.setAdditionalItem(additionaItemService.getByKey(transactionAdditionalItemInput.getAdditionalItem()));
        transactionAdditionalItem.setValue(transactionAdditionalItemInput.getValue());

        return transactionAdditionalItem;
    }
}
