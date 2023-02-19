package com.springboot.graphql.service.additionalmethod;

import com.springboot.graphql.dto.AdditionalItemInput;
import com.springboot.graphql.dto.PaymentMethodInput;
import com.springboot.graphql.entity.AdditionalItem;
import com.springboot.graphql.entity.PaymentMethod;
import com.springboot.graphql.helper.map.MapAdditionalItem;
import com.springboot.graphql.helper.map.MapPaymentMethod;
import com.springboot.graphql.repository.AdditionalItemRepository;
import com.springboot.graphql.repository.PaymentMethodRepository;
import graphql.GraphQLException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdditionalItemServiceImpl implements AdditionalItemService {

    private final AdditionalItemRepository additionalItemRepository;

    private final PaymentMethodRepository paymentMethodRepository;

    private final MapAdditionalItem mapAdditionalItem;
    private final MapPaymentMethod mapPaymentMethod;

    private static final Integer DEFAULT_SKIP = 0;

    private static final Integer DEFAULT_LIMIT = 4;

    @Override
    public AdditionalItem add(AdditionalItemInput additionalItemInput) {
        PaymentMethod paymentMethod = mapPaymentMethod.mapInputToPaymentMethod(additionalItemInput.getPaymentMethodInput());
        AdditionalItem additionalItem = mapAdditionalItem.mapInputToAdditionalItem(additionalItemInput, paymentMethod);
        return additionalItemRepository.save(additionalItem);
    }

    @Override
    public AdditionalItem getById(Long id) {
        return additionalItemRepository.findById(id).get();
    }

    @Override
    public List<AdditionalItem> get(Integer skip, Integer limit) {
        return additionalItemRepository.get(skip == null ? DEFAULT_SKIP : skip, limit == null ? DEFAULT_LIMIT : limit);
    }

    private PaymentMethod findPaymentMethodById(Long id) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id).get();
        if (paymentMethod == null)
            throw new GraphQLException("There is no Trade Type according with id: " + id);

        return paymentMethod;
    }

	@Override
	public List<AdditionalItem> get(PaymentMethodInput paymentMethodInput, Integer skip, Integer limit) {
		return additionalItemRepository.findByPaymentMethod(paymentMethodInput.getName(), skip == null ? DEFAULT_SKIP : skip, limit == null ? DEFAULT_LIMIT : limit);
	}

	@Override
    public AdditionalItem getByKey(String key) {
        return additionalItemRepository.findByKey(key).get();
    }

}
