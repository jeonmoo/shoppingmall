package com.example.coupang.domain.orders;

import com.example.coupang.domain.baseTime.BaseTime;
import com.example.coupang.domain.orders.Orders;
import com.example.coupang.domain.product.Product;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class OrdersDetail extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @Setter private String orderNumber;
    @Setter private String productCode;
    @Setter private BigDecimal unitPrice;   // 개당 가격
    @Setter private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "orders.id")
    private Orders orders;

    @OneToOne
    @JoinColumn(name = "product.id")
    private Product product;

    @Builder
    public OrdersDetail(String productCode, BigDecimal unitPrice, Integer quantity) {
        this.productCode = productCode;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}