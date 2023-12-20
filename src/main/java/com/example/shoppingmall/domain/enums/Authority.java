package com.example.shoppingmall.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Authority {

    // 권한관
    COMMON("일반권한"),
    ADMIN("관리자권한");

    private final String description;
}