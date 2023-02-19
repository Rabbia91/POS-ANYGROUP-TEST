package com.springboot.graphql.entity;

import com.springboot.graphql.entity.enums.Currency;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "payment_method")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
@ToString
public class PaymentMethod {

    @Id
    @SequenceGenerator(name = "seq_payment_method", allocationSize = 1)
    @GeneratedValue(generator = "seq_payment_method", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private Float minPriceModifier;

    private Float maxPriceModifier;
    
    private Float pointsModifier;
    
    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<AdditionalItem> additionalItem = new HashSet<>();

}
