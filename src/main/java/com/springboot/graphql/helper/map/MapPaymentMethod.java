package com.springboot.graphql.helper.map;

import com.springboot.graphql.dto.AdditionalItemInput;
import com.springboot.graphql.dto.PaymentMethodInput;
import com.springboot.graphql.entity.AdditionalItem;
import com.springboot.graphql.entity.PaymentMethod;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class MapPaymentMethod {
	
	private MapAdditionalItem mapAdditionalItem;

    public PaymentMethod mapInputToPaymentMethod(PaymentMethodInput paymentMethodInput) {
    	PaymentMethod paymentMethod = new PaymentMethod();

    	paymentMethod.setName(paymentMethodInput.getName());
    	paymentMethod.setMinPriceModifier(paymentMethodInput.getMinPriceModifier());
    	paymentMethod.setMaxPriceModifier(paymentMethodInput.getMaxPriceModifier());
    	paymentMethod.setPointsModifier(paymentMethodInput.getPointsModifier());
    	
    	Set<AdditionalItem> sets = new HashSet();
    	
    	if(!paymentMethodInput.getAdditionalItem().isEmpty()){
    	
	    	for(AdditionalItemInput ai : paymentMethodInput.getAdditionalItem()){
	    		
	    		AdditionalItem additionalItem = new AdditionalItem();
	    		additionalItem.setKey(ai.getKey());
	    		additionalItem.setRegex(ai.getRegex());
	    		additionalItem.setPaymentMethod(paymentMethod);
	    		sets.add(additionalItem);
	    		
	    	}
    	}
    	
    	paymentMethod.setAdditionalItem(sets);

        return paymentMethod;
    }
}
