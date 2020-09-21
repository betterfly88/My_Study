package com.kakao.app.service;

import com.kakao.app.domain.RegistUserDto;
import com.kakao.common.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class RegistService {
    static final Logger logger = LoggerFactory.getLogger(RegistService.class);

    /*
     1) 고객 행동을 시뮬레이션 하고 금융 거래 로그를 발생시킨다.
            a. 고객의 가장 처음 로그는 “가입 → 계좌개설” 순서로 진행된다. (계좌가 유니크해야함)
            b. 계좌개설 이후부터는 “입금, 출금, 이체” 중 하나의 거래가 진행된다.
            c. 고객의 계좌 잔액은 0원 미만이 될 수 없다.
     */
    public Customer generateCustomer(RegistUserDto userDto){
        /*
            repository의 customerNo + 1 값으로
            RegistUser 맵핑하기
         */
//        return new Customer(userDto);

        return null;
    }
}