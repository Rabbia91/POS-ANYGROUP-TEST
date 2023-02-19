package com.springboot.graphql.entity;

import com.springboot.graphql.entity.enums.Currency;
import lombok.*;

import javax.persistence.*;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "transaction")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
@ToString
public class Transaction {

    @Id
    @SequenceGenerator(name = "seq_transaction", allocationSize = 1)
    @GeneratedValue(generator = "seq_transaction", strategy = GenerationType.SEQUENCE)
    private Long id;

    private Float price;
    
    private Float finalPrice;
    
    private Float priceModifier;
    
    private Float points;

    private Date datetime;

    private String customerId;
    
    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;
    
    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TransactionAdditionalItem> additionalItem = new HashSet<>();


}
