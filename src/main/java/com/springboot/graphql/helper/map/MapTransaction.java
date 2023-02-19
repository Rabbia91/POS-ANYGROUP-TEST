package com.springboot.graphql.helper.map;

import com.springboot.graphql.dto.AdditionalItemInput;
import com.springboot.graphql.dto.TransactionAdditionalItemInput;
import com.springboot.graphql.dto.TransactionInput;
import com.springboot.graphql.entity.AdditionalItem;
import com.springboot.graphql.entity.PaymentMethod;
import com.springboot.graphql.entity.Transaction;
import com.springboot.graphql.entity.TransactionAdditionalItem;
import com.springboot.graphql.exception.PaymentMethodNotAvailable;
import com.springboot.graphql.exception.PriceModifierOutOfRange;
import com.springboot.graphql.repository.AdditionalItemRepository;
import com.springboot.graphql.service.additionalmethod.AdditionalItemService;
import com.springboot.graphql.service.paymentmethod.PaymentMethodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class MapTransaction {
	
	@Autowired
    private PaymentMethodService paymentMethodService;
	
	@Autowired
    private AdditionalItemService additionalItemervice;

	
    public Transaction mapInputToTransaction(TransactionInput transactionInput) {
        Transaction transaction = new Transaction();
        
        transaction.setCustomerId(transactionInput.getCustomerId());
        transaction.setPrice(transactionInput.getPrice());
        transaction.setPriceModifier(transactionInput.getPriceModifier()); 
        transaction.setDatetime(transactionInput.getDatetime());
        
        PaymentMethod pm;
        try{
        	pm = paymentMethodService.getByName(transactionInput.getPaymentMethod());
        }catch(Exception e){
        	throw new PaymentMethodNotAvailable("Payment Method Not available.");
        }
        
        transaction.setPaymentMethod(pm);
        transaction.setDatetime(transaction.getDatetime());
        
        Set<TransactionAdditionalItem> sets = new HashSet();
    	
    	if(!transactionInput.getAdditionalItem().isEmpty()){
    	
	    	for(TransactionAdditionalItemInput ai : transactionInput.getAdditionalItem()){
	    		
	    		TransactionAdditionalItem additionalItem = new TransactionAdditionalItem();
	    		
	    		additionalItem.setTransaction(transaction);
	    		additionalItem.setValue(ai.getValue());
	    		additionalItem.setAdditionalItem(additionalItemervice.getByKey(ai.getAdditionalItem()));
	    		sets.add(additionalItem);
	    		
	    	}
    	}
    	
    	transaction.setAdditionalItem(sets);

        return transaction;
    }
}
