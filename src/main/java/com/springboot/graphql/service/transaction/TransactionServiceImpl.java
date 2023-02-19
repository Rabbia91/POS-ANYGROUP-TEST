package com.springboot.graphql.service.transaction;

import com.springboot.graphql.dto.TransactionInput;
import com.springboot.graphql.entity.AdditionalItem;
import com.springboot.graphql.entity.PaymentMethod;
import com.springboot.graphql.entity.Transaction;
import com.springboot.graphql.entity.TransactionAdditionalItem;
import com.springboot.graphql.exception.PriceModifierOutOfRange;
import com.springboot.graphql.helper.map.MapTransaction;
import com.springboot.graphql.repository.TransactionRepository;
import com.springboot.graphql.service.paymentmethod.PaymentMethodService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final PaymentMethodService pmService;

    private final MapTransaction mapTransaction;

    private static final Integer DEFAULT_SKIP = 0;

    private static final Integer DEFAULT_LIMIT = 4;

    @Override
    public Transaction add(TransactionInput transactionInput){
    	Transaction transaction = mapTransaction.mapInputToTransaction(transactionInput);
    	
   		PaymentMethod pm = transaction.getPaymentMethod();
   		    	
    	if(priceModifierOutOfRange(transaction))
    		throw new PriceModifierOutOfRange("Price modifier out of range for available discount.");
    	
    	if(isAdditionalItemIIncorrect(transaction))
    		throw new PriceModifierOutOfRange("Additional Item Missing or Invalid");
    	  	
    	transaction.setFinalPrice(transaction.getPriceModifier() * transaction.getPrice());
    	transaction.setPoints(pm.getPointsModifier() * transaction.getPrice());
    	
        return transactionRepository.save(transaction);
    }
   
   private Boolean isAdditionalItemIIncorrect(Transaction transaction){
	   
	   Set<AdditionalItem> pmAdditionalItems = transaction.getPaymentMethod().getAdditionalItem();
	   Set<TransactionAdditionalItem> transactionAdditionalItems = transaction.getAdditionalItem();
	   
	   if((pmAdditionalItems == null && transactionAdditionalItems != null) || (pmAdditionalItems != null && transactionAdditionalItems == null))
			   return true;
			   
	   if(pmAdditionalItems.size() != transactionAdditionalItems.size()) return true;
	   
	   for(AdditionalItem item : pmAdditionalItems){
		   
		   Boolean flag = true;
		   for(TransactionAdditionalItem transitionItem : transactionAdditionalItems){
			   
			   if(item.getKey().equals(transitionItem.getAdditionalItem().getKey())){
				   flag = false;
				   
				   if(!transitionItem.getValue().matches(item.getRegex()))
					   return true;
				   
			   }
			   
		   }
		   
		   if(flag) return true;
		   
	   }
	   
	   
	   return false;
   }
    
   private Boolean priceModifierOutOfRange(Transaction transaction){
	   
   		PaymentMethod pm = transaction.getPaymentMethod();
   		Float min = pm.getMinPriceModifier();
    	Float max = pm.getMaxPriceModifier();
    	
    	if(transaction.getPriceModifier() >= min && transaction.getPriceModifier() <= max)
    		return false;
    	
    	return true;
	   
   }

    @Override
    public Transaction getById(Long id) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public List<Transaction> get(Integer skip, Integer limit) {
        return transactionRepository.get(skip == null ? DEFAULT_SKIP : skip, limit == null ? DEFAULT_LIMIT : limit);
    }

	@Override
	public List<Transaction> transactionsBetween(Date start, Date end) {
		return transactionRepository.findByDatetimeBetween(start,end);
	}
}
