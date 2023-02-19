package com.springboot.graphql.entity;

import com.springboot.graphql.entity.enums.Currency;
import lombok.*;

import javax.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "transaction_additional_item")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
@ToString
public class TransactionAdditionalItem {

    @Id
    @SequenceGenerator(name = "seq_transaction_additional_items", allocationSize = 1)
    @GeneratedValue(generator = "seq_transaction_additional_items", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String value;
    
    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private AdditionalItem additionalItem;
    
}
