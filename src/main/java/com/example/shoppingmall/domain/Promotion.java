package com.example.shoppingmall.domain;

import com.example.shoppingmall.domain.baseEntity.BaseEntity;
import com.example.shoppingmall.domain.enums.CardCompany;
import com.example.shoppingmall.domain.product.Product;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Promotion extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Setter private String promotionCode;
    @Setter private CardCompany cardCompany;
    @Setter private BigDecimal discountRate;
    @Setter private LocalDateTime promotionStartDateTime;
    @Setter private LocalDateTime promotionEndDateTime;

    @ManyToOne
    @JoinColumn(name = "product.id")
    private Product product;
}
