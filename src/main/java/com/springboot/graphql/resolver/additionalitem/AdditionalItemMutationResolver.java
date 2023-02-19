package com.springboot.graphql.resolver.additionalitem;

import com.springboot.graphql.dto.AdditionalItemInput;
import com.springboot.graphql.entity.AdditionalItem;
import com.springboot.graphql.service.additionalmethod.AdditionalItemService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AdditionalItemMutationResolver implements GraphQLMutationResolver {

    private final AdditionalItemService additionalItemService;

    public AdditionalItem addAdditionalItem(AdditionalItemInput additionalItemInput) {
        return additionalItemService.add(additionalItemInput);
    }
}
