package com.example.shoppingmall.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OrderStatus {
    ORDER_REGISTRATION("주문등록"),
    ORDER_PAID("결제완료");

    private final String description;
}
