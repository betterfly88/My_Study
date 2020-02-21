package com.class101.homework.common;

import lombok.Getter;

@Getter
public enum ErrorStatus {
    EXCEED_ORDER_CLASS(0, "클래스 상품은 1개만 신청이 가능합니다."),
    ALREADY_EXISTS_CLASS(1, "이미 등록한 클래스 입니다."),
    OUT_OF_STOCK(3, "해당 키트 상품은 재고가 소진되었습니다.")
    ;

    private int code;
    private String message;


    ErrorStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
