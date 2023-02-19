package com.springboot.graphql.entity;

import com.springboot.graphql.entity.enums.Currency;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "additional_item")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
@ToString
public class AdditionalItem {

    @Id
    @SequenceGenerator(name = "seq_additional_item", allocationSize = 1)
    @GeneratedValue(generator = "seq_additional_item", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String regex;

    private String key;

    @ManyToOne(fetch = FetchType.EAGER)
    private PaymentMethod paymentMethod;
}
