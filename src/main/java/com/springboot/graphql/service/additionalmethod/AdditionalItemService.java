package com.springboot.graphql.service.additionalmethod;

import com.springboot.graphql.dto.AdditionalItemInput;
import com.springboot.graphql.dto.PaymentMethodInput;
import com.springboot.graphql.entity.PaymentMethod;
import com.springboot.graphql.entity.AdditionalItem;

import java.util.List;

public interface AdditionalItemService {

    AdditionalItem add(AdditionalItemInput additionalItemInput);

    AdditionalItem getById(Long id);

    List<AdditionalItem> get(Integer skip, Integer limit);

	List<AdditionalItem> get(PaymentMethodInput paymentMethodInput, Integer skip, Integer limit);
	
	AdditionalItem getByKey(String key);


}